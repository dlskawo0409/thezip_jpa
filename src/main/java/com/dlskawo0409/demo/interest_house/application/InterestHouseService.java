package com.dlskawo0409.demo.interest_house.application;//package com.dlskawo0409.demo.interest_house.application;
//
//import com.dlskawo0409.demo.interest_house.domain.InterestHouse;
//import com.dlskawo0409.demo.interest_house.domain.InterestHouseRepository;
//import com.dlskawo0409.demo.interest_house.dto.request.InterestHouseInsertRequest;
//import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class InterestHouseService {
//
//    private final InterestHouseRepository interestHouseRepository;
//
//    public void insertInterestHouse(InterestHouseInsertRequest interestHouseInsertRequest,
//                                    CustomMemberDetails loginMember){
//
//        InterestHouse interestHouse = InterestHouse.builder()
//                .member(loginMember.getMember())
//                .aptSeq(interestHouseInsertRequest.aptSeq())
//                .build();
//
//        interestHouseRepository.save(interestHouse);
//    }
//
//    public List<InterestHouseWithHouseDeal> getInterestHouse(CustomMemberDetails loginMember){
//        return interestHouseRepository.findHouseDeal(loginMember.getMemberId());
//    }
//
//    @Transactional
//    public void removeInterestHouse(String aptSeq, CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException {
//        boolean isAdmin = loginMember.getAuthorities().stream()
//                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
////        if(!(isOwner(loginMember.getMemberId(), aptSeq) || isAdmin)){
////            throw new MemberException.MemberBadRequestException(MemberErrorCode.FORBIDDEN_ACCESS);
////        }
//
//        interestHouseRepository.delete(aptSeq, loginMember.getMemberId());
//    }
////    public boolean isOwner(Long memberId, String aptSeq) {
////        return interestHouseRepository.existsByMemberIdAndInterestHouseId(memberId, aptSeq);
////    }
//
//}
