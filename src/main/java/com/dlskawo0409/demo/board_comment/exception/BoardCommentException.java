package com.dlskawo0409.demo.board_comment.exception;

import com.dlskawo0409.demo.common.exception.ErrorCode;
import org.apache.coyote.BadRequestException;

public class BoardCommentException {
    public static class BoardCommentBadRequestException extends BadRequestException {
        public BoardCommentBadRequestException(BoardCommentErrorCode errorCode) {
            super(String.valueOf(new ErrorCode<>(errorCode.getCode(), errorCode.getMessage())));
        }
    }
}
