package com.melog.melog.domain.auth.service;

import com.melog.melog.domain.auth.dto.AuthSignUpDto;
import com.melog.melog.domain.auth.dto.SignInDto;
import com.melog.melog.domain.user.entity.Role;
import com.melog.melog.domain.user.entity.User;
import com.melog.melog.domain.user.repository.UserRepository;
import com.melog.melog.global.error.BusinessException;
import com.melog.melog.global.response.ResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

import static com.melog.melog.global.error.ErrorCode.EMAIL_ALREADY_EXISTS;
import static com.melog.melog.global.response.ResultCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResultCode signIn(SignInDto signInDto) throws AuthenticationException {
        try {
            String email = signInDto.email();
            String password = signInDto.password();

            User existingUser = userRepository.findByEmail(email).orElse(null);
            if (existingUser == null) {
                return LOGIN_FAILED_EMAIL_NULL;
            }

            if (!existingUser.getPassword().equals(password)) {
                return LOGIN_FAILED_PASSWORD_NULL;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("AuthService - SignIn : {}", e.getMessage());
            return UNKNOWN_ERROR;
        }
        return LOGIN_SUCCESS;
    }

    @Transactional
    public void signUp(AuthSignUpDto authSignUpDto){
        if (userRepository.existsByEmail(authSignUpDto.email())) {
            throw new BusinessException(EMAIL_ALREADY_EXISTS);
        }
        User user = User.builder()
                .email(authSignUpDto.email())
                .password(passwordEncoder.encode(authSignUpDto.password()))
                .name(authSignUpDto.name())
                .age(authSignUpDto.age())
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }
}
