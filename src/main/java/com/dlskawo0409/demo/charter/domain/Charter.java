package com.dlskawo0409.demo.charter.domain;

import com.dlskawo0409.demo.common.image.domain.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Charter {
    @Id
    @GeneratedValue
    private Long charterId;
    private CharterKind charterKind;
    private Integer dealYear;
    private Integer dealMonth;
    private Integer dealDay;
    private Integer deposit;
    private Integer rent;
    private String name;
    private Float size;
    private Integer constructionYear;
    private BuildingUse buildingUse;
    private Long memberId;
    private String charterDong;
    private String charterGu;
    private Integer bonbun;
    private Integer bubun;
    private String preCode;
    private String postCode;
    private Image image;


}
