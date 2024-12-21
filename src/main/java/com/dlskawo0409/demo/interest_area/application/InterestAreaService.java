package com.dlskawo0409.demo.interest_area.application;

import com.dlskawo0409.demo.dongcode.domain.DongCodeRepository;
import com.dlskawo0409.demo.dongcode.dto.response.SidoGugunDongResponse;
import com.dlskawo0409.demo.interest_area.domain.InterestArea;
import com.dlskawo0409.demo.interest_area.domain.InterestAreaRepository;
import com.dlskawo0409.demo.interest_area.dto.request.InterestAreaInsertRequest;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        System.out.println(stringBuilder.toString());

        InterestArea interestArea = InterestArea.builder()
                .dongCode(interestAreaInsertRequest.dongCode())

                .build();

        try {
            interestAreaRepository.save(interestAreaInsertDTO, stringBuilder.toString(), loginMember.getMemberId());
        } catch (DataIntegrityViolationException e) {
            // Unique 제약 조건 위반일 경우
            throw new InterestAreaException.InterestAreaConflictException(InterestAreaErrorCode.DUPLICATE_DONG_CODE, interestAreaInsertDTO.getDongCode());
        }
    }

    public List<InterestArea> getInterestArea(CustomMemberDetails loginMember){
        return interestAreaRepository.findByMemberId(loginMember.getMemberId());
    }

    public void deleteInterestArea(Long interestAreaId, CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException {
        boolean isAdmin = loginMember.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        if(!(isOwner(loginMember.getMemberId(), interestAreaId) || isAdmin)){
            throw new MemberException.MemberBadRequestException(MemberErrorCode.FORBIDDEN_ACCESS);
        }

        interestAreaRepository.delete(interestAreaId);
    }

    public boolean isOwner(Long memberId, Long interestHouseId) {
        return interestAreaRepository.existsByMemberIdAndInterestAreaId(memberId, interestHouseId);
    }

}
