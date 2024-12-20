package com.dlskawo0409.demo.charter.domain;

import com.dlskawo0409.demo.common.Image.domain.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
public class Charter {
    @Id
    @GeneratedValue
    private Long CharterId;
    private CharterKind charterKind;
    private String floor;
    private int dealYear;
    private int dealMonth;
    private int dealDay;
    private int deposit;
    private int rent;
    private String name;
    private float size;
    private int constructionYear;
    private BuildingUse buildingUse;
    private String charterDong;
    private String charterGu;
    private Integer bonbun;
    private Integer bubun;
    private String preCode;
    private String postCode;
    private Image image;

}
