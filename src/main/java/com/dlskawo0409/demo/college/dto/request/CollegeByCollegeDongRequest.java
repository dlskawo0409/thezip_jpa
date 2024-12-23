package com.dlskawo0409.demo.college.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;


public record CollegeByCollegeDongRequest(
        @Schema(description = "동코드", required = true, example = "1111010100")
        String collegeDong
) {

}
