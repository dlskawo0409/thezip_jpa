package com.dlskawo0409.demo.board.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BoardUpdateRequest(
        @NotBlank
        Long boardId,
        String title,
        String content

) {
}
