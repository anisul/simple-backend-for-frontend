package com.grasshopper.simplebackendforfrontend.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoredIpInfo {
    String activity;
    Double accessibility;
    String requesterIp;
    String requesterLoc;
    String requesterTimezone;
}
