package com.dlskawo0409.demo.board.exception;

import lombok.Getter;

@Getter
public enum BoardErrorCode {

    BOARD_NOT_FOUND("01000", "존재하지 않는 글입니다.");
    private final String code;
    private final String message;

    BoardErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
