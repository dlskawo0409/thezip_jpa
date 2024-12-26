package com.dlskawo0409.demo.houseinfo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record LatitudeAndLongitude(
        String aptSeq,
        String latitude,
        String Longitude,
        String dealAmount
) {
}
