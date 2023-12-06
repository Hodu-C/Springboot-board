package com.melog.melog.domain.auth.controller;


import com.melog.melog.domain.auth.dto.SignInDto;
import com.melog.melog.domain.auth.dto.AuthSignUpDto;
import com.melog.melog.domain.auth.service.AuthService;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;


@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ResultResponse> signup(@Valid @RequestBody AuthSignUpDto authSignUpDto){
        authService.signUp(authSignUpDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SIGNUP_SUCCESS));
    }

    @PostMapping("/signin")
    public ResponseEntity<ResultResponse> signIn(@Valid @RequestBody SignInDto signInDto) throws AuthenticationException {
        ResultCode result = authService.signIn(signInDto);
        return ResponseEntity.ok(ResultResponse.of(result));
    }
}

