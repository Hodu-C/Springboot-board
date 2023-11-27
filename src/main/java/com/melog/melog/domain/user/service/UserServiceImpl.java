package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.User;
import com.melog.melog.domain.user.dto.UserInfoDto;
import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.dto.UserUpdateDto;
import com.melog.melog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signUp(UserSignUpDto userSignUpDto) throws Exception {
        User user = userSignUpDto.toEntity();

        userRepository.save(user);
    }

    @Override
    public void update(UserUpdateDto userUpdateDto, String email) throws Exception {

    }

    @Override
    public void updatePassword(String asIsPassword, String toBePassword, String email) throws Exception {

    }

    @Override
    public void withdraw(String checkPassword, String email) throws Exception {

    }

    @Override
    public UserInfoDto getInfo(Long id) throws Exception {
        return null;
    }

    @Override
    public UserInfoDto getMyInfo() throws Exception {
        return null;
    }
}
