package com.dlskawo0409.demo.board_comment.dto.request;

public record BoardCommentInsertRequest(
    Long boardId,
    String content
) {
}
