package com.dlskawo0409.demo.interest_house.domain;

import com.dlskawo0409.demo.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
public class InterestHouse {

    @Id
    @GeneratedValue
    private Long interestHouseId;

    @ManyToOne
    private Member member;


    private String aptSeq;
}
