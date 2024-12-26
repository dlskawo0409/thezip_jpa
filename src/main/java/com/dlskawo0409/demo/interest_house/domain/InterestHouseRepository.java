package com.dlskawo0409.demo.interest_house.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestHouseRepository extends JpaRepository<InterestHouse, Long> {

    Integer countByAptSeq(String aptSeq);

//    InterestHouse findByMemberIdAndAptSeq(Long memberId, String aptSeq);
}
