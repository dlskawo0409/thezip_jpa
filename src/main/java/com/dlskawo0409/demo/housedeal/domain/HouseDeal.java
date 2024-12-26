package com.dlskawo0409.demo.housedeal.domain;

import com.dlskawo0409.demo.houseinfo.domain.HouseInfo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class HouseDeal{
    @Id
    @GeneratedValue
    private Long no;

    String floor;
    Integer dealYear;
    Integer dealMonth;
    Integer dealDay;
    Float size;
    String dealAmount;

    @ManyToOne
    private HouseInfo houseInfo;



}
