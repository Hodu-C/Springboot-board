package com.melog.melog.domain.user.dto.request;

import com.melog.melog.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Pageable;

public record UserInfoDto(String name, String email, Integer age)
{}
