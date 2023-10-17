package com.grasshopper.simplebackendforfrontend.client.ipInfoApi;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ipInfoApi", url = "https://www.boredapi.com/")
public interface IpInfoApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{ip}/geo")
    IpInfoApiResponse getIpInfo(@PathVariable("ip") String ip);
}
