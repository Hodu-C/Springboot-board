package com.melog.melog.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BOARD_NOT_FOUND(400, "게시물을 찾을 수 없습니다."),
    USER_NOT_FOUND(400, "유저 정보를 찾을 수 없습니다."),
    LOGIN_FAILED_EMAIL_NULL(400, "이메일이 존재하지 않습니다."),
    LOGIN_FAILED_PASSWORD_NULL(400, "패스워드가 틀립니다."),
    UNKNOWN_ERROR(400, "알 수 없는 오류가 발생했습니다.");

    private final int status;
    private final String message;
}