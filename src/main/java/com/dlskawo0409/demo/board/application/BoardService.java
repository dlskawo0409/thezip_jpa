package com.dlskawo0409.demo.board.application;

import com.dlskawo0409.demo.board.domain.Board;
import com.dlskawo0409.demo.board.domain.BoardRepository;
import com.dlskawo0409.demo.board.dto.request.BoardInsertRequest;
import com.dlskawo0409.demo.board.dto.request.BoardUpdateRequest;
import com.dlskawo0409.demo.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void insertBoard(BoardInsertRequest boardInsertRequest){
        Board board = Board.builder()
                .title(boardInsertRequest.title())
                .content(boardInsertRequest.content())
                .author(boardInsertRequest.author())
                .build();

        boardRepository.save(board);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public void update(BoardUpdateRequest boardUpdateRequest){
        Optional<Board> board = Optional.ofNullable(boardRepository.findById(boardUpdateRequest.boardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + boardUpdateRequest.boardId())));
    }
}
