package com.melog.melog.domain.user.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record UserUpdateDto(

        @Nullable
        String name,

        @Positive(message = "숫자를 입력해주세요")
        Integer age
){}
