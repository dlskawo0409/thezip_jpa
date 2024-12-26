package com.dlskawo0409.demo.houseinfo.dto.response;

import com.dlskawo0409.demo.common.image.dto.response.ImageResponseDTO;
import com.dlskawo0409.demo.housedeal.domain.HouseDeal;

import java.util.List;

public record HouseInfoWithHouseDeals(
        String aptSeq,
        String preDongCode,
        String postDongCode,
        String dongName,
        String jibun,
        String roadName,
        String roadNameBonbun, // 도로명 주소 본번
        String roadNameBubun,
        String apartName,
        Integer buildYear,
        String latitude,
        String longitude,
        Boolean isInterested,
        Integer likes,
        List<ImageResponseDTO> imageResponseDTOList,
        List<HouseDeal> houseDealList

) {
}
