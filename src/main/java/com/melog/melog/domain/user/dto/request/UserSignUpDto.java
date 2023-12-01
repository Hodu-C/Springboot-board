package com.melog.melog.domain.user.dto.request;

import com.melog.melog.domain.user.entity.Role;
import com.melog.melog.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public record UserSignUpDto(
        @NotBlank(message = "이메일을 입력해주세요")
        @Email(message = "올바른 이메일 형식을 입력해주세요")
        String email,

        @NotBlank(message = "비밀번호를 입력해주세요")
        String password,

        @NotBlank(message = "이름을 입력해주세요")
        String name,

        @Positive(message = "숫자를 입력해주세요")
        Integer age
) {

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .age(age)
                .role(Role.USER).build();
    }
}
