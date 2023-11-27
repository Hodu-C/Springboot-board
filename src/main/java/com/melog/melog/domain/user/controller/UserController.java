package com.melog.melog.domain.user.controller;

import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    //회원가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public void signup(@Valid @RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);
    }
}
