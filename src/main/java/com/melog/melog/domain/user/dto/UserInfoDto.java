package com.melog.melog.domain.user.dto;

import com.melog.melog.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDto {
    private String name;
    private String email;
    private Integer age;

    @Builder
    public UserInfoDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.age = user.getAge();
    }

}
