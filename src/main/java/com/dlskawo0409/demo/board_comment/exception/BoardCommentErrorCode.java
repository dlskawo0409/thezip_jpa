package com.dlskawo0409.demo.board_comment.exception;

import lombok.Getter;

@Getter
public enum BoardCommentErrorCode {

    BOARD_COMMENT_NOT_FOUND("02000", "존재하지 않는 댓글입니다.");
    private final String code;
    private final String message;

    BoardCommentErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }


}
