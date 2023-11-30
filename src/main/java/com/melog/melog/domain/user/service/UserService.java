package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.dto.UserInfoDto;
import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.dto.UserUpdateDto;

public interface UserService {

    void signUp(UserSignUpDto userSignUpDto) throws Exception;

    void update(Long id, UserUpdateDto userUpdateDto) throws Exception;

    UserInfoDto getInfo(Long id) throws Exception;

    UserInfoDto getMyInfo() throws Exception;


}
