package com.dlskawo0409.demo.member.dto.response;

import com.dlskawo0409.demo.member.domain.Blocked;
import com.dlskawo0409.demo.member.domain.Gender;
import com.dlskawo0409.demo.member.domain.Role;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record MemberGetResponse (
        Long memberId,
        String username,
        String nickname,
        Gender gender,
        Blocked blocked,

        Role role,
        String profile,
        LocalDateTime createdAt,
        Long collegeId
){

}
