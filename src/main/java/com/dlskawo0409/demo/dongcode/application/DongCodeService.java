package com.dlskawo0409.demo.dongcode.application;

import com.dlskawo0409.demo.dongcode.domain.DongCodeRepository;
import com.dlskawo0409.demo.dongcode.dto.response.SidoGugunDongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DongCodeService {

    private final DongCodeRepository dongCodeRepository;

    public List<String> getSido(){
        return dongCodeRepository.findSido();
    }

    public List<String> getGugunBySido(String sido){
        return dongCodeRepository.findGugunBySido(sido.trim());
    }

    public List<String> getDongByGugun(String sido, String gugun){
        return dongCodeRepository.findDongByGugun(sido.trim(),gugun.trim());
    }

    public String getDongCodeByDong(String sido, String gugun, String dong){
        return dongCodeRepository.findDongCodeByDong(sido.trim(),gugun.trim(),dong.trim());
    }

    public SidoGugunDongResponse getSidoGugunDong(String dongCode){
        return dongCodeRepository.findSidoGugunDongByDongCode(dongCode);
    }

}
