package com.melog.melog.domain.user.controller;

import com.melog.melog.domain.user.dto.request.UserSignUpDto;
import com.melog.melog.domain.user.dto.request.UserUpdateDto;
import com.melog.melog.domain.user.entity.User;
import com.melog.melog.domain.user.service.UserService;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> info(@PathVariable Long id){
        User data = userService.info(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.INFO_SUCCESS, data));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SIGNUP_SUCCESS));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) throws Exception {
        User data = userService.update(id, userUpdateDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.UPDATE_SUCCESS, data));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
