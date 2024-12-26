package com.dlskawo0409.demo.charter.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;

public enum CharterKind implements CodedEnum<String> {
    MONTHLY_RENT("월세"),
    YEARLY_RENT("전세");

    private String key;

    CharterKind(String key){
        this.key = key;
    }

    @Override
    public String getKey() {
        return null;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<CharterKind, String> {
        public Converter() {
            super(CharterKind.class);
        }
    }
}
