package com.dlskawo0409.demo.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardInsertRequest (
        @NotBlank
        String title,
        String content
){
}
 