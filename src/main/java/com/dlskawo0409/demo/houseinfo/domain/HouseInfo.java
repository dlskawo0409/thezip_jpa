package com.dlskawo0409.demo.houseinfo.domain;

import com.dlskawo0409.demo.common.image.domain.Image;
import com.dlskawo0409.demo.housedeal.domain.HouseDeal;
import com.dlskawo0409.demo.interest_house.domain.InterestHouse;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class HouseInfo {
    @Id
    private String aptSeq;
    private String preDongCode;
    private String postDongCode;
    private String dongName;
    private String jibun;
    private String roadName;
    private String roadNameBonbun; // 도로명 주소 본번
    private String roadNameBubun;
    private String apartName;
    private Integer buildYear;
    private String latitude;
    private String longitude;
    private Integer floor;
    private Float area;

    @OneToMany(mappedBy = "houseInfo", fetch = FetchType.LAZY)
    private List<HouseDeal> houseDealList;

    @OneToOne
    private InterestHouse interestHouse;
}
