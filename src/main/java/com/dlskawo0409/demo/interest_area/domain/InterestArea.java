package com.dlskawo0409.demo.interest_area.domain;

import com.dlskawo0409.demo.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;


@Entity
@Builder
public class InterestArea {
    @Id
    @GeneratedValue
    Long interestAreaId;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    String name;

    @Column(nullable = false)
    String dongCode;
}
