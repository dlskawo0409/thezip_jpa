package com.dlskawo0409.demo.college.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CollegeByNameRequest (
        @Schema(description = "대학이름", required = true, example = "한국")
        String collegeName
){
}
