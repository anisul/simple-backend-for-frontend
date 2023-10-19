package com.grasshopper.simplebackendforfrontend.service;

import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiClient;
import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiResponse;
import com.grasshopper.simplebackendforfrontend.client.ipInfoApi.IpInfoApiClient;
import com.grasshopper.simplebackendforfrontend.client.ipInfoApi.IpInfoApiResponse;
import com.grasshopper.simplebackendforfrontend.types.BoredIpInfo;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class BoredIpServiceImpl implements BoredIpService {

    private final BoredApiClient boredApiClient;
    private final IpInfoApiClient ipInfoApiClient;

    @Override
    @Timed(value = "getBoredIpInfoSync")
    public BoredIpInfo getBoredIpInfo(String ip) {

        var boredApiResponse = boredApiClient.getActivities();
        var ipInfoApiResponse = ipInfoApiClient.getIpInfo(ip);


        var result = BoredIpInfo.builder()
                .accessibility(boredApiResponse.getAccessibility())
                .activity(boredApiResponse.getActivity())
                .requesterIp(ipInfoApiResponse.getIp())
                .requesterLoc(ipInfoApiResponse.getLoc())
                .requesterTimezone(ipInfoApiResponse.getTimezone())
                .build();

        return result;
    }

    @Override
    @Timed(value = "getBoredIpInfoAsync")
    public BoredIpInfo getBoredIpInfoAsync(String ip) {
        CompletableFuture<BoredApiResponse> boredApiResponseFuture = CompletableFuture.supplyAsync(boredApiClient::getActivities);
        CompletableFuture<IpInfoApiResponse> ipInfoApiResponseFuture = CompletableFuture.supplyAsync(() -> ipInfoApiClient.getIpInfo(ip));

        return CompletableFuture.allOf(boredApiResponseFuture, ipInfoApiResponseFuture)
                .thenApplyAsync(ignoredVoid -> {
                    var boredApiResponse = boredApiResponseFuture.join();
                    var ipInfoApiResponse = ipInfoApiResponseFuture.join();

                    return BoredIpInfo.builder()
                            .accessibility(boredApiResponse.getAccessibility())
                            .activity(boredApiResponse.getActivity())
                            .requesterIp(ipInfoApiResponse.getIp())
                            .requesterLoc(ipInfoApiResponse.getLoc())
                            .requesterTimezone(ipInfoApiResponse.getTimezone())
                            .build();
                })
                .join(); // Wait for the combined result and return it.
    }
}
