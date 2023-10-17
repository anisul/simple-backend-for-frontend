package com.grasshopper.simplebackendforfrontend.service;

import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiClient;
import com.grasshopper.simplebackendforfrontend.client.boredApi.BoredApiResponse;
import com.grasshopper.simplebackendforfrontend.client.ipInfoApi.IpInfoApiClient;
import com.grasshopper.simplebackendforfrontend.client.ipInfoApi.IpInfoApiResponse;
import com.grasshopper.simplebackendforfrontend.types.BoredIpInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoredIpServiceImplTest {

    @Mock
    private BoredApiClient boredApiClient;

    @Mock
    private IpInfoApiClient ipInfoApiClient;

    private BoredIpServiceImpl boredIpService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        boredIpService = new BoredIpServiceImpl(boredApiClient, ipInfoApiClient);
    }

    @Test
    public void testGetBoredIpInfo() {
        String ipAddress = "161.185.160.93";

        BoredApiResponse boredApiResponse = BoredApiResponse.builder()
                .accessibility(0.5)
                .activity("Test Activity")
                .build();

        IpInfoApiResponse ipInfoApiResponse = IpInfoApiResponse.builder()
                .ip(ipAddress)
                .loc("Test Location")
                .timezone("Test Timezone")
                .build();

        when(boredApiClient.getActivities()).thenReturn(boredApiResponse);
        when(ipInfoApiClient.getIpInfo(ipAddress)).thenReturn(ipInfoApiResponse);

        BoredIpInfo result = boredIpService.getBoredIpInfo(ipAddress);

        BoredIpInfo expected = BoredIpInfo.builder()
                .accessibility(0.5)
                .activity("Test Activity")
                .requesterIp(ipAddress)
                .requesterLoc("Test Location")
                .requesterTimezone("Test Timezone")
                .build();

        assertEquals(expected, result);
    }
}