package com.melog.melog.domain.user.dto;

import com.melog.melog.domain.user.User;


public record UserSignUpDto(String email, String password, String name, Integer age) {

    public User toEntity() {
        return User.builder().email(email).password(password).name(name).age(age).build();
    }
}
