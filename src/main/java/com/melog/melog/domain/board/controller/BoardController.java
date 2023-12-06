package com.melog.melog.domain.board.controller;


import com.melog.melog.domain.board.dto.BoardInfoDto;
import com.melog.melog.domain.board.dto.BoardCreateDto;
import com.melog.melog.domain.board.dto.BoardEditDto;
import com.melog.melog.domain.board.service.BoardService;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<ResultResponse> findAllBoards(@PageableDefault(size = 5, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardInfoDto> data = boardService.findAllBoards(pageable);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_FINDALL_SUCCESS, data));
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<ResultResponse> findBoard(@PathVariable long boardId) {
        BoardInfoDto data = boardService.findBoard(boardId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_FIND_SUCCESS, data));
    }

    @PostMapping("/boards/users/{userId}")
    public ResponseEntity<ResultResponse> createBoard(@PathVariable long userId,
                                                      @Valid @RequestBody BoardCreateDto boardCreateDto) {
         boardService.createBoard(userId, boardCreateDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_CREATE_SUCCESS));
    }

    @PatchMapping("/boards/{boardId}")
    public ResponseEntity<ResultResponse> editBoard(@PathVariable long boardId,
                                                    @Valid @RequestBody BoardEditDto boardEditDto) {
        boardService.editBoard(boardId, boardEditDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_EDIT_SUCCESS));
    }

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<ResultResponse> deleteBoard(@PathVariable long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DELETE_SUCCESS));
    }
}
