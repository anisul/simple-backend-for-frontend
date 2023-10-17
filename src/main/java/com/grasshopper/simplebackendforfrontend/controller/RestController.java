package com.grasshopper.simplebackendforfrontend.controller;

import com.grasshopper.simplebackendforfrontend.service.BoredIpService;
import com.grasshopper.simplebackendforfrontend.types.BoredIpInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class RestController {

    private final BoredIpService boredIpService;

    @GetMapping(value = "/v1/api/bored-ip/{ip}")
    public BoredIpInfo getBoredIpInfo(@PathVariable("ip") String ip) {
        return boredIpService.getBoredIpInfo(ip);
    }
}
