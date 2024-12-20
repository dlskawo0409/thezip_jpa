package com.dlskawo0409.demo.charter.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;
import com.dlskawo0409.demo.member.domain.Role;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CharterKind implements CodedEnum<String> {
    MONTHLY_RENT("월세"),
    YEARLY_RENT("전세");


    private String key;

    CharterKind(String key){
        this.key = key;
    }

//    @JsonCreator
//    public static CharterKind from(String input) {
//        if (input == null || input.trim().isEmpty()) {
//            return null;
//        }
//        return Arrays.stream(values())
//                .filter(charterKind -> charterKind.key.equals(input) || charterKind.name().equalsIgnoreCase(input))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 값: " + input));
//    }


    @JsonValue
    public String getKey() {
        return key;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<CharterKind, String> {
        public Converter() {
            super(CharterKind.class);
        }
    }


}
