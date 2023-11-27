package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.dto.UserInfoDto;
import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.dto.UserUpdateDto;

public interface UserService {
    void signUp(UserSignUpDto userSignUpDto) throws Exception;

    void update(UserUpdateDto userUpdateDto, String email) throws Exception;

    void updatePassword(String asIsPassword, String toBePassword, String email) throws Exception;

    void withdraw(String checkPassword, String email) throws Exception;

    UserInfoDto getInfo(Long id) throws Exception;

    UserInfoDto getMyInfo() throws Exception;


}
