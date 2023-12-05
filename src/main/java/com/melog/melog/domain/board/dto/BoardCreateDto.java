package com.melog.melog.domain.board.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class BoardCreateDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

}
