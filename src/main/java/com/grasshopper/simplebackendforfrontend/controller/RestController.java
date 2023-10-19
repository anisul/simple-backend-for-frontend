package com.grasshopper.simplebackendforfrontend.controller;

import com.grasshopper.simplebackendforfrontend.service.BoredIpService;
import com.grasshopper.simplebackendforfrontend.types.BoredIpInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final BoredIpService boredIpService;

    @GetMapping(value = "/v1/api/bored-ip/{ip}")
    public BoredIpInfo getBoredIpInfo(@PathVariable("ip") String ip) {
        return boredIpService.getBoredIpInfoAsync(ip);
    }
}
