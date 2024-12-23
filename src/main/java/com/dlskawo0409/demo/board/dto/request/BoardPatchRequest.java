package com.dlskawo0409.demo.board.dto.request;

public record BoardPatchRequest(
        String title,
        String content,
        String author
) {
}
