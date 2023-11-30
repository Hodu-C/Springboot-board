package com.melog.melog.domain.auth.controller;


import com.melog.melog.domain.auth.dto.SignInDto;
import com.melog.melog.domain.auth.service.AuthService;
import com.melog.melog.global.error.BusinessException;
import com.melog.melog.global.error.ErrorCode;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.io.IOException;

import static com.melog.melog.global.response.ResultCode.LOGIN_SUCCESS;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<ResultResponse> signIn(@Valid @RequestBody SignInDto signInDto) throws AuthenticationException {
        ResultCode result = authService.signIn(signInDto);

        return ResponseEntity.ok(ResultResponse.of(result));
    }
}

