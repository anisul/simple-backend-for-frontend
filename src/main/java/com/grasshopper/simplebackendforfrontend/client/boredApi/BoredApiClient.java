package com.grasshopper.simplebackendforfrontend.client.boredApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "boredApi", url = "https://www.boredapi.com/")
public interface BoredApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/activity")
    BoredApiResponse getActivities();
}
