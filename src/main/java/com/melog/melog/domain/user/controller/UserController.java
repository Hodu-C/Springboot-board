package com.melog.melog.domain.user.controller;

import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.dto.UserUpdateDto;
import com.melog.melog.domain.user.service.UserService;
import com.melog.melog.domain.user.service.UserServiceImpl;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/user/{id}")
//    public


    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SIGNUP_SUCCESS));
    }

    //회원 정보 수정

    //dto 이름? 필드 이름 어떻게 짓는게 나을까? 목적명시?
    //throws Exception 간단 파악.
    //GlobalExceptionHandler 사용해보기(@RestControllerAdvice) 스프링의 예외처리 이해
    //@Builder
    //ResponseEntity, Optional<>(람다, 스트림), enum(열거형), Generics, 컬렉션프레임워크 공부 필요
    //Controller, Service 분리 이유 및 각각 클래스에서 해야될 것들

    @PatchMapping("/update/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) throws Exception {
        userService.update(id, userUpdateDto);
    }





}
