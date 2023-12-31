package com.melog.melog.domain.user.controller;

import com.melog.melog.domain.user.dto.request.UserUpdateDto;
import com.melog.melog.domain.user.entity.User;
import com.melog.melog.domain.user.service.UserService;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.melog.melog.global.response.ResultCode.INFO_SUCCESS;
import static com.melog.melog.global.response.ResultCode.UPDATE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> info(@PathVariable Long id){
        User data = userService.info(id);
        return ResponseEntity.ok(ResultResponse.of(INFO_SUCCESS, data));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDto userUpdateDto){
        User data = userService.update(id, userUpdateDto);
        return ResponseEntity.ok(ResultResponse.of(UPDATE_SUCCESS, data));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
