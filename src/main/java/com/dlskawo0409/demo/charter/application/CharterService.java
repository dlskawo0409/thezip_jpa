package com.dlskawo0409.demo.charter.application;

import com.dlskawo0409.demo.charter.domain.Charter;
import com.dlskawo0409.demo.charter.domain.CharterRepository;
import com.dlskawo0409.demo.charter.dto.request.CharterInfoRequest;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharterService {

    private final CharterRepository charterRepository;

//    @Value("${basic.image.charter}")
//    private String charterBasicImageName;

    public List<Charter> getCharterList(CharterInfoRequest charterInfoRequest,
                                        CustomMemberDetails loginMember){
        return charterRepository.findCharterByDongCode(charterInfoDTO, loginMember == null ? null : loginMember.getMemberId());
    }

    public Long getCharterResultCount(CharterInfoDTO charterInfoDTO){
        return charterRepository.findCountByDongCode(charterInfoDTO);
    }

    public List<CharterInfoListResponseDTO> getCharterListByName(String name){
        return charterRepository.findByName(name);
    }
    public List<Charter> getCharterById(Long charterId, CustomMemberDetails loginMember){
        return charterRepository.findById(charterId, loginMember == null ? null : loginMember.getMemberId());
    }

    public List<Charter> getCharterByLikes(String charterKind , Integer count){
        return charterRepository.findByLikes(charterKind, count);
    }



    @Transactional
    public List<Charter> getCharterListBySidoGugunDong(CharterInfoBySidoGugunDongDTO charterInfoBySidoGugunDongDTO,
                                                       CustomMemberDetails loginMember){
        String dongCode = dongCodeRepository.findDongCodeByDong(charterInfoBySidoGugunDongDTO.getSido(),
                charterInfoBySidoGugunDongDTO.getGugun(),
                charterInfoBySidoGugunDongDTO.getDong());

        charterInfoBySidoGugunDongDTO.changeDongCode(dongCode);

        return charterRepository.findCharterBySidoGugunDong(charterInfoBySidoGugunDongDTO,
                loginMember == null ? null : loginMember.getMemberId());
    }


    @Transactional
    public void postCharter(CharterInsertDTO charterInsertDTO, MultipartFile multipartFile, CustomMemberDetails loginMember) throws IOException {
        Long memberId  = memberRepository.findByUsername(loginMember.getUsername()).getMemberId();
        charterInsertDTO.changeDongCode(); // 동 코드를 분리

        Charter charter = Charter.builder()
                .preCode(charterInsertDTO.getPreCode())
                .postCode(charterInsertDTO.getPostCode())
                .charterKind(charterInsertDTO.getCharterKind())
                .floor(charterInsertDTO.getFloor())
                .dealYear(charterInsertDTO.getDealYear())
                .dealMonth(charterInsertDTO.getDealMonth())
                .dealDay(charterInsertDTO.getDealDay())
                .deposit(charterInsertDTO.getDeposit())
                .rent(charterInsertDTO.getRent())
                .name(charterInsertDTO.getName())
                .size(charterInsertDTO.getSize())
                .constructionYear(charterInsertDTO.getConstructionYear())
                .buildingUse(charterInsertDTO.getBuildingUse())
                .charterGu(charterInsertDTO.getCharterGu())
                .charterDong(charterInsertDTO.getCharterDong())
                .bonbun(charterInsertDTO.getBonbun())
                .bubun(charterInsertDTO.getBubun())
                .memberId(memberId)
                .build();

        charterRepository.save(charter);

        if(multipartFile == null){
            ImageInsertByURLDTO imageInsertByURLDTO = new ImageInsertByURLDTO();
            imageInsertByURLDTO.setImageType(ImageType.CHARTER);
            imageInsertByURLDTO.setImageUrl(charterBasicImageName);
            imageInsertByURLDTO.setReferenceId(String.valueOf(charter.getCharterId()));
            imageService.upload(imageInsertByURLDTO);
            return;
        }

        imageService.upload(multipartFile, String.valueOf(charter.getMemberId()), ImageType.CHARTER);
    }

    public void updateCharter(CharterUpdateDTO charterUpdateDTO, CustomMemberDetails loginMember){
        charterUpdateDTO.changeDongCode();
        Long memberId = loginMember.getAuthorities().iterator().next().getAuthority().equals(Role.ADMIN.getKey()) ? null : loginMember.getMemberId();

        charterRepository.updateCharter(charterUpdateDTO, memberId);
    }

    public List<Charter> getCharterList(CustomMemberDetails loginMember){
        return charterRepository.findCharterByMemberId(loginMember.getMemberId());
    }

    @Transactional
    public void deleteCharter(Long charterId , CustomMemberDetails loginMember){
        Long memberId = loginMember.getAuthorities().iterator().next().getAuthority().equals(Role.ADMIN.getKey()) ? null : loginMember.getMemberId();

        List<ImageResponseDTO> imageResponseDTOList = imageService.getImage(String.valueOf(charterId), ImageType.CHARTER);
        for(ImageResponseDTO  imageResponseDTO : imageResponseDTOList){
            imageService.delete(imageResponseDTO.getImageId());
        }
        charterRepository.delete(charterId, memberId);
    }

}
