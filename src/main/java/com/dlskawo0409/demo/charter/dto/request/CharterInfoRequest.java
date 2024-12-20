package com.dlskawo0409.demo.charter.dto.request;

import com.dlskawo0409.demo.charter.domain.CharterKind;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharterInfoRequest {
    private String preCode;
    private String postCode;

    private DealInfoDTO deposit = new DealInfoDTO();
    private DealInfoDTO rent = new DealInfoDTO();

    private Integer start;
    private Integer limit;
    private CharterKind charterKind;

    public void changeDongCode(String dongCode){
        this.preCode = dongCode.substring(0,5);
        this.postCode = dongCode.substring(5,10);
    }
}
