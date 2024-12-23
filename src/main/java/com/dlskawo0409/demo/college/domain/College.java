package com.dlskawo0409.demo.college.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private String collegeEnglishName;


    private String branchType;
    private String regionName;
    private String roadAddress;
    private String homePage;
}

