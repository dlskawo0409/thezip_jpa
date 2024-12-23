package com.dlskawo0409.demo.common.image.domain;

import com.dlskawo0409.demo.common.util.AbstractCodedEnumConverter;
import com.dlskawo0409.demo.common.util.CodedEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageType implements CodedEnum<String> {

    PROFILE("PROFILE", "profile_image");

    private final String key;
    private final String url;

    ImageType(String key, String url) {
        this.key = key;
        this.url = url;
    }

    @JsonValue
    public String getKey() {
        return this.key;
    }


    public String getUrl(){
        return this.url;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<ImageType, String> {
        public Converter() {
            super(ImageType.class);
        }
    }
}
