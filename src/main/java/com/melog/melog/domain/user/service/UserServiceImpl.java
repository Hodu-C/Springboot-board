package com.melog.melog.domain.user.service;

import com.melog.melog.domain.user.entity.User;
import com.melog.melog.domain.user.dto.request.UserUpdateDto;
import com.melog.melog.domain.user.repository.UserRepository;
import com.melog.melog.global.error.BusinessException;
import com.melog.melog.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User info(Long id){
        User user = userRepository.findById(id).orElseThrow(()->
                new BusinessException(ErrorCode.USER_NOT_FOUND));
        return user;
    }

    @Override
    @Transactional
    public User update(Long id, UserUpdateDto userUpdateDto){
        User user = userRepository.findById(id).orElseThrow(()->
                new BusinessException(ErrorCode.USER_NOT_FOUND));
        user.updateName(userUpdateDto.name());
        user.updateAge(userUpdateDto.age());
        return user;
    }

    @Override
    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(()->
                new BusinessException(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(user.getId());
    }
}
