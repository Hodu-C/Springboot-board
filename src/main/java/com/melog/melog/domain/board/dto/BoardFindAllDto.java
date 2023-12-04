package com.melog.melog.domain.board.dto;


import com.melog.melog.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardFindAllDto {
    private String title;
    private String content;
    private String name;

    public static BoardFindAllDto toDto(Board board) {
        return new BoardFindAllDto(board.getTitle(), board.getContent(), board.getUser().getName());
    }

}
