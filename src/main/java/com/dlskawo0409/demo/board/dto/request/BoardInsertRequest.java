package com.dlskawo0409.demo.board.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BoardInsertRequest (
        @NotBlank
        String title,
        String content
){
}
 