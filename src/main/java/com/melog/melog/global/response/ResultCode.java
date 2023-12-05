package com.melog.melog.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    //회원
    INFO_SUCCESS(200, "회원 정보를 조회합니다."),
    SIGNUP_SUCCESS(201, "회원가입에 성공하였습니다."),
    LOGIN_SUCCESS(200, "로그인에 성공하였습니다."),
    UPDATE_SUCCESS(200, "회원 정보를 수정하였습니다."),


    //게시글
    BOARD_CREATE_SUCCESS(201, "게시물을 작성하였습니다."),
    BOARD_EDIT_SUCCESS(200, "게시물을 수정하였습니다."),
    BOARD_DELETE_SUCCESS(200, "게시물을 삭제하였습니다."),
    BOARD_FIND_SUCCESS(200, "게시물을 조회합니다"),
    BOARD_FINDALL_SUCCESS(200, "전체 게시물을 조회합니다."),


    //에러
    LOGIN_FAILED_EMAIL_NULL(400, "이메일이 존재하지 않습니다."),
    LOGIN_FAILED_PASSWORD_NULL(400, "패스워드가 틀립니다."),
    UNKNOWN_ERROR(400, "알 수 없는 오류가 발생했습니다.");


    private final int status;
    private final String message;
}
