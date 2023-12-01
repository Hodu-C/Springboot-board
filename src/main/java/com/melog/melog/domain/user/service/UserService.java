package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.dto.request.UserSignUpDto;
import com.melog.melog.domain.user.dto.request.UserUpdateDto;
import com.melog.melog.domain.user.entity.User;

public interface UserService {

    User info(Long id);

    void signUp(UserSignUpDto userSignUpDto) throws Exception;

    User update(Long id, UserUpdateDto userUpdateDto) throws Exception;

    void delete(Long id);
}
