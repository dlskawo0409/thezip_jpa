package com.dlskawo0409.demo.member.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;

public enum Gender implements CodedEnum<Integer> {
    MALE(0),
    FEMALE(1);

    private final Integer key;

    Gender(int key) {
        this.key = key;
    }
    public Integer getKey() {
        return key;
    }
    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<Gender, Integer> {
        public Converter() {
            super(Gender.class);
        }
    }
}
