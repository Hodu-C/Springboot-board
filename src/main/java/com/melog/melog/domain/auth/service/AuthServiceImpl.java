package com.melog.melog.domain.auth.service;

import com.melog.melog.domain.auth.dto.SignInDto;
import com.melog.melog.domain.user.User;
import com.melog.melog.domain.user.repository.UserRepository;
import com.melog.melog.global.error.*;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

import com.melog.melog.global.error.GlobalExceptionHandler;

import static com.melog.melog.global.response.ResultCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;


    @Override
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
}
