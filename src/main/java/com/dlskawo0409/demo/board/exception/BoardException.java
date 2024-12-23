package com.dlskawo0409.demo.board.exception;

import com.dlskawo0409.demo.common.exception.ErrorCode;
import org.apache.coyote.BadRequestException;

public class BoardException {

    public static class BoardBadRequestException extends BadRequestException {
        public BoardBadRequestException(BoardErrorCode errorCode) {
            super(String.valueOf(new ErrorCode<>(errorCode.getCode(), errorCode.getMessage())));
        }
    }

}
