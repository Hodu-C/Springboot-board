package com.melog.melog.domain.board.controller;


import com.melog.melog.domain.board.dto.BoardFindAllDto;
import com.melog.melog.domain.board.dto.BoardCreateDto;
import com.melog.melog.domain.board.dto.BoardEditDto;
import com.melog.melog.domain.board.entity.Board;
import com.melog.melog.domain.board.service.BoardService;
import com.melog.melog.global.response.ResultCode;
import com.melog.melog.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping()
    public ResponseEntity<Page<BoardFindAllDto>> findAllBoards(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardFindAllDto> boardFindAllDtoPage = boardService.findAllBoards(pageable);
        return new ResponseEntity<>(boardFindAllDtoPage, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> findBoard(@PathVariable long boardId) {
        Board data = boardService.findBoard(boardId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_FIND_SUCCESS, data));
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<?> createBoard(@PathVariable long userId, @RequestBody BoardCreateDto boardPostDto) {
        Board data = boardService.createBoard(userId, boardPostDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_CREATE_SUCCESS, data));
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<?> editBoard(@PathVariable long boardId, @RequestBody BoardEditDto boardUpdateDto) {
        Board data = boardService.editBoard(boardId, boardUpdateDto);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_EDIT_SUCCESS, data));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DELETE_SUCCESS));
    }
}
