package com.melog.melog.domain.user.dto.request;

import com.melog.melog.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Pageable;

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
