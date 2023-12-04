package com.melog.melog.domain.board.service;


import com.melog.melog.domain.board.dto.BoardFindAllDto;
import com.melog.melog.domain.board.dto.BoardCreateDto;
import com.melog.melog.domain.board.dto.BoardEditDto;
import com.melog.melog.domain.board.entity.Board;
import com.melog.melog.domain.board.repository.BoardRepository;
import com.melog.melog.domain.user.entity.User;
import com.melog.melog.domain.user.repository.UserRepository;
import com.melog.melog.global.error.BusinessException;
import com.melog.melog.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<BoardFindAllDto> findAllBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAll(pageable);
        return boards.map(BoardFindAllDto::toDto);
    }

    @Transactional(readOnly = true)
    public Board findBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new BusinessException((ErrorCode.BOARD_NOT_FOUND)));
        board.increaseCount();
        return board;
    }

    @Transactional
    public Board createBoard(long id, BoardCreateDto boardCreateDto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.USER_NOT_FOUND));

        Board board = Board.builder()
                .user(user)
                .title(boardCreateDto.getTitle())
                .content(boardCreateDto.getContent())
                .build();
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public Board editBoard(long id, BoardEditDto boardEditDto) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new BusinessException((ErrorCode.BOARD_NOT_FOUND)));
        board.setTitle(boardEditDto.getTitle());
        board.setContent(boardEditDto.getContent());
        return board;
    }

    @Transactional
    public void deleteBoard(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new BusinessException((ErrorCode.BOARD_NOT_FOUND)));
        boardRepository.delete(board);
    }


}
