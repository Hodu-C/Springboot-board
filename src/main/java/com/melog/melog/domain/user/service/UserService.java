package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.dto.request.UserUpdateDto;
import com.melog.melog.domain.user.entity.User;

public interface UserService {

    User info(Long id);



    User update(Long id, UserUpdateDto userUpdateDto);

    void delete(Long id);
}
