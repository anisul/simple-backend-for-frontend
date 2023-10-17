package com.grasshopper.simplebackendforfrontend.client.ipInfoApi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IpInfoApiResponse {
    String ip;
    String city;
    String region;
    String country;
    String loc;
    String org;
    String postal;
    String timezone;
    String readme;
}
