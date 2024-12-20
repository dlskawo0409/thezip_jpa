package com.dlskawo0409.demo.charter.dto.response;

import com.dlskawo0409.demo.charter.domain.CharterKind;

public record CharterInfoResponse (
        Long CharterId,
        CharterKind charterKind,
        String floor,
        
){
}
