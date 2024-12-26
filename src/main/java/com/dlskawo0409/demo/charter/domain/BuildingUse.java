package com.dlskawo0409.demo.charter.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;

public enum BuildingUse implements CodedEnum<String> {

    OFFICE("오피스텔"),
    SINGLE_FAMILY("단독다가구"),
    APARTMENT("아파트"),
    MULTI_FAMILY("연립다세대");
    private final String key;

    BuildingUse(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return null;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<BuildingUse, String> {
        public Converter() {
            super(BuildingUse.class);
        }
    }
}
