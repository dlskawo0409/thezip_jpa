package com.dlskawo0409.demo.houseinfo.application;

import com.dlskawo0409.demo.common.image.domain.Image;
import com.dlskawo0409.demo.common.image.domain.ImageRepository;
import com.dlskawo0409.demo.common.image.domain.ImageType;
import com.dlskawo0409.demo.common.image.dto.response.ImageResponseDTO;
import com.dlskawo0409.demo.housedeal.domain.HouseDeal;
import com.dlskawo0409.demo.houseinfo.domain.HouseInfo;
import com.dlskawo0409.demo.houseinfo.domain.HouseInfoRepository;
import com.dlskawo0409.demo.houseinfo.dto.request.HouseInfoRequest;
import com.dlskawo0409.demo.houseinfo.dto.response.HouseInfoWithHouseDeals;
import com.dlskawo0409.demo.houseinfo.dto.response.LatitudeAndLongitude;
import com.dlskawo0409.demo.interest_house.domain.InterestHouse;
import com.dlskawo0409.demo.interest_house.domain.InterestHouseRepository;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseInfoService {

    private final HouseInfoRepository houseInfoRepository;
    private final InterestHouseRepository interestHouseRepository;
    private final ImageRepository imageRepository;

    public List<HouseInfoWithHouseDeals> getHouseInfoWithHouseDealsByDongCode(HouseInfoRequest houseInfoRequest,
                                                                              CustomMemberDetails loginMember){
        Long memberId = loginMember == null ? null : loginMember.getMemberId();

        List<HouseInfo> houseInfos = houseInfoRepository.findByPreDongCodeAndPostDongCode(houseInfoRequest.getPostDongCode(),
                houseInfoRequest.getPostDongCode());

        List<HouseInfoWithHouseDeals> houseInfoWithHouseDeals = houseInfos.stream().sorted().map(houseInfo -> {
            // 관심 아파트 여부
            boolean isInterested = houseInfo.getInterestHouse() != null &&
                    houseInfo.getInterestHouse().getMember().getMemberId().equals(memberId);

            List<Image> imageList =  imageRepository.findByImageTypeAndReferenceId(ImageType.APARTMENT, houseInfo.getAptSeq());

            List<ImageResponseDTO> imageResponseDTOList = imageList.stream()
                    .map(image -> ImageResponseDTO.builder()
                            .imageId(image.getImageId())
                            .imageURL(image.getImageUrl())
                            .imageType(image.getImageType())
                            .build())
                    .collect(Collectors.toList());

            // HouseInfoWithHouseDeals DTO 생성
            return new HouseInfoWithHouseDeals(
                    houseInfo.getAptSeq(),
                    houseInfo.getPreDongCode(),
                    houseInfo.getPostDongCode(),
                    houseInfo.getDongName(),
                    houseInfo.getJibun(),
                    houseInfo.getRoadName(),
                    houseInfo.getRoadNameBonbun(),
                    houseInfo.getRoadNameBubun(),
                    houseInfo.getApartName(),
                    houseInfo.getBuildYear(),
                    houseInfo.getLatitude(),
                    houseInfo.getLongitude(),
                    isInterested,
                    interestHouseRepository.countByAptSeq(houseInfo.getAptSeq()),
                    imageResponseDTOList,
                    houseInfo.getHouseDealList()
            );
        }).collect(Collectors.toList());

        return houseInfoWithHouseDeals;

    }

//    public List<LatitudeAndLongitude> getLatitudeAndLongitudeByDongCode(HouseInfoRequest houseInfoRequest){
//        return houseInfoRepository.findLatitudeAndLongitudeByDongCode(houseInfoDTO);
//    }
public HouseInfoWithImagesDTO getHouseInfoWithHouseDealsByDongCodeOnlyOne(String aptSeq,
                                                                          CustomMemberDetails loginMember){
        HouseInfo houseInfo = houseInfoRepository.findByAptSeq(aptSeq);


    return houseInfoRepository.findAllByDongCodeOnlyOne(aptSeq, loginMember == null ? null : loginMember.getMemberId());
}



}
