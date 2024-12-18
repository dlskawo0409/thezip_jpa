package com.dlskawo0409.demo.member.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;

public enum Blocked implements CodedEnum<Integer> {
    UNBLOCKED(0),
    BLOCKED(1);

    private int key;

    Blocked (int key){
        this.key = key;
    }

    @Override
    public Integer getKey() {
        return this.key;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<Blocked, Integer> {
        public Converter() {
            super(Blocked.class);
        }
    }

}
