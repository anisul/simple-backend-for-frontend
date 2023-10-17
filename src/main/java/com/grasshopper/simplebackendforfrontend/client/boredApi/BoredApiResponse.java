package com.grasshopper.simplebackendforfrontend.client.boredApi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoredApiResponse {
    String activity;
    String type;
    Double participant;
    Double price;
    String link;
    Double key;
    Double accessibility;
}
