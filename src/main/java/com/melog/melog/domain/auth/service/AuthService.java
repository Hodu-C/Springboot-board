package com.melog.melog.domain.auth.service;

import com.melog.melog.domain.auth.dto.SignInDto;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import org.springframework.http.ResponseEntity;

import javax.naming.AuthenticationException;

public interface AuthService {
    public ResultCode signIn(SignInDto signInDto) throws AuthenticationException;
}
