package com.dlskawo0409.demo.houseinfo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseInfoRequest {
    private String preDongCode;
    private String postDongCode;
    private DealInfoDTO dealInfoDTO;

    public HouseInfoRequest(String dongCode){
        this.preDongCode = dongCode.substring(0,5);
        this.postDongCode = dongCode.substring(5,10);
    }

}
