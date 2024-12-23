package com.dlskawo0409.demo.interest_area.domain;

import com.dlskawo0409.demo.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestAreaRepository extends JpaRepository<InterestArea, Long> {
    List<InterestArea> findByMember(Member member);
    boolean existsByMemberAndInterestAreaId(Member member, Long interestAreaId);

}
