package com.dlskawo0409.demo.interest_house.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record InterestHouseInsertRequest(
        @Schema(description = "아파트 seq", required = true, example = "11170-16")
        String aptSeq
) {
}
