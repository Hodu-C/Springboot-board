package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.User;
import com.melog.melog.domain.user.dto.UserInfoDto;
import com.melog.melog.domain.user.dto.UserSignUpDto;
import com.melog.melog.domain.user.dto.UserUpdateDto;
import com.melog.melog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signUp(UserSignUpDto userSignUpDto) throws Exception {
        User user = userSignUpDto.toEntity();
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, UserUpdateDto userUpdateDto) throws Exception {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        //변경 전 user
        log.info("변경 전 = {}", user);
        user.setName(userUpdateDto.changeName());
        user.setAge(userUpdateDto.changeAge());

        //변경 후 user
        log.info("변경 후 = {}", user);
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
