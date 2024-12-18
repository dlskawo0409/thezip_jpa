package com.dlskawo0409.demo.member.dto.request;

import com.dlskawo0409.demo.member.domain.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;


public record MemberInsertRequest(
        @NotBlank(message = "닉네임은 공백이 될 수 없습니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        String username,

        @NotBlank(message = "비밀번호는 공백이 될 수 없습니다.")
        @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하여야 합니다.")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()-+=<>?]).+$",
                message = "비밀번호는 최소 하나의 소문자, 숫자 및 특수문자를 포함해야 합니다."
        )
        String password,

        @NotBlank(message = "닉네임은 공백이 될 수 없습니다.")
        String nickname,

        @NotNull(message = "성별은 공백이 될 수 없습니다.")
        @Schema(description = "성별", required = true, example = "MALE")
        Gender gender

) {

}
