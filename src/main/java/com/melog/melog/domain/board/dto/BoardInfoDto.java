package com.melog.melog.domain.board.dto;


import com.melog.melog.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardInfoDto {

    private Long id;
    private String title;
    private String content;
    private long count;
    private String name;

    public static BoardInfoDto toDto(Board board) {
        return new BoardInfoDto(board.getId(), board.getTitle(), board.getContent(),board.getCount(),
                board.getUser().getName());
    }

}
