package com.dlskawo0409.demo.charter.application;

import com.dlskawo0409.demo.charter.domain.Charter;
import com.dlskawo0409.demo.charter.domain.CharterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharterService {

    private final CharterRepository charterRepository;

    public List<Charter> getCharterList(CharterInfoDTO charterInfoDTO,
                                        CustomMemberDetails loginMember){
        return charterRepository.findCharterByDongCode(charterInfoDTO, loginMember == null ? null : loginMember.getMemberId());
    }


}
