package com.dlskawo0409.demo.dongcode.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class DongCode {

    @Id
    private String DongCode;

    private String sidoName;
    private String gugunName;
    private String dongName;
}
