package com.grasshopper.simplebackendforfrontend.service;

import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiClient;
import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiResponse;
import com.grasshopper.simplebackendforfrontend.client.ipInfoApi.IpInfoApiClient;
import com.grasshopper.simplebackendforfrontend.types.BoredIpInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BoredIpServiceImpl implements BoredIpService {

    private final BoredApiClient boredApiClient;
    private final IpInfoApiClient ipInfoApiClient;

    @Override
    public BoredIpInfo getBoredIpInfo(String ip) {

        var boredApiResponse = boredApiClient.getActivities();
        var ipInfoApiResponse = ipInfoApiClient.getIpInfo(ip);

        var topBoredApiInfo = boredApiResponse.stream()
                .findFirst()
                .orElse(BoredApiResponse.builder().build());

        var result = BoredIpInfo.builder()
                .accessibility(topBoredApiInfo.getAccessibility())
                .activity(topBoredApiInfo.getActivity())
                .requesterIp(ipInfoApiResponse.getIp())
                .requesterLoc(ipInfoApiResponse.getLoc())
                .requesterTimezone(ipInfoApiResponse.getTimezone())
                .build();

        return result;
    }
}
