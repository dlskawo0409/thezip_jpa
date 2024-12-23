package com.dlskawo0409.demo.interest_area.application;

import com.dlskawo0409.demo.dongcode.domain.DongCodeRepository;
import com.dlskawo0409.demo.dongcode.dto.response.SidoGugunDongResponse;
import com.dlskawo0409.demo.interest_area.domain.InterestArea;
import com.dlskawo0409.demo.interest_area.domain.InterestAreaRepository;
import com.dlskawo0409.demo.interest_area.dto.request.InterestAreaInsertRequest;
import com.dlskawo0409.demo.member.domain.Member;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import com.dlskawo0409.demo.member.exception.MemberErrorCode;
import com.dlskawo0409.demo.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestAreaService {

    private final InterestAreaRepository interestAreaRepository;
    private final DongCodeRepository dongCodeRepository;

    public void insertInterestArea(InterestAreaInsertRequest interestAreaInsertRequest,
                                   CustomMemberDetails loginMember) {
        SidoGugunDongResponse sidoGugunDongResponse = dongCodeRepository.findSidoGugunDongByDongCode(interestAreaInsertRequest.dongCode());
        StringBuilder stringBuilder = new StringBuilder(sidoGugunDongResponse.sido()+" ");
        stringBuilder.append(sidoGugunDongResponse.gugun()+" ");
        stringBuilder.append(sidoGugunDongResponse.dong());

        InterestArea interestArea = InterestArea.builder()
                .member(loginMember.getMember())
                .dongCode(interestAreaInsertRequest.dongCode())
                .name(stringBuilder.toString())
                .build();

        interestAreaRepository.save(interestArea);

    }

    public List<InterestArea> getInterestArea(CustomMemberDetails loginMember){
        return interestAreaRepository.findByMember(loginMember.getMember());
    }

    public void deleteInterestArea(Long interestAreaId, CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException {
        if(isOwner(loginMember.getMember(),interestAreaId )){
          throw new MemberException.MemberBadRequestException(MemberErrorCode.FORBIDDEN_ACCESS);
        }
        interestAreaRepository.deleteById(interestAreaId);
    }

    public boolean isOwner(Member member, Long interestAreaId) {
        return interestAreaRepository.existsByMemberAndInterestAreaId(member, interestAreaId);
    }

}
