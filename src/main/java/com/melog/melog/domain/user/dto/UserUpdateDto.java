package com.melog.melog.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UserUpdateDto(

        //수정할 수 있는 것들 - 이름, 나이
        @NotBlank(message = "이름을 입력해주세요")
        String changeName,
        @Positive(message = "숫자를 입력해주세요")
        Integer changeAge
){}
