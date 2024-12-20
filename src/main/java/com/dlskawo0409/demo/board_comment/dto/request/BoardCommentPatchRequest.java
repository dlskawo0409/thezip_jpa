package com.dlskawo0409.demo.board_comment.dto.request;

public record BoardCommentPatchRequest(
        String content,
        String author
) {
}
