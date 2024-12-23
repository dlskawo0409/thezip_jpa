package com.dlskawo0409.demo.board.application;

import com.dlskawo0409.demo.board.domain.Board;
import com.dlskawo0409.demo.board.domain.BoardRepository;
import com.dlskawo0409.demo.board.dto.request.BoardInsertRequest;
import com.dlskawo0409.demo.board.dto.request.BoardPatchRequest;
import com.dlskawo0409.demo.board.exception.BoardErrorCode;
import com.dlskawo0409.demo.board.exception.BoardException;
import com.dlskawo0409.demo.common.domain.BasicEntity;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import jakarta.persistence.Basic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void insertBoard(BoardInsertRequest boardInsertRequest, CustomMemberDetails loginMember){

        Board board = Board.builder()
                .title(boardInsertRequest.title())
                .content(boardInsertRequest.content())
                .author(loginMember.getMember().getNickname())
                .build();

        boardRepository.save(board);
    }

    public List<Board> findIsNotDeleted(){
        return boardRepository.findByBasicEntity_DeletedAtIsNull();
    }

    @Transactional
    public void patchBoard(Long boardId, BoardPatchRequest patchDTO) throws BoardException.BoardBadRequestException {
        // 기존 데이터 조회
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardException.BoardBadRequestException(BoardErrorCode.BOARD_NOT_FOUND));

        // 업데이트할 필드만 수정
        if (patchDTO.title() != null) {
            board.setTitle(patchDTO.title());
        }
        if (patchDTO.content() != null) {
            board.setContent(patchDTO.content());
        }
        if (patchDTO.author() != null) {
            board.setAuthor(patchDTO.author());
        }
    }



    public void delete(Long boardId) throws BoardException.BoardBadRequestException {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardException.BoardBadRequestException(BoardErrorCode.BOARD_NOT_FOUND));

        BasicEntity basicEntity =  board.getBasicEntity();
        basicEntity.setDeletedAt(LocalDateTime.now());

        board.setBasicEntity(basicEntity);
        boardRepository.save(board);

        //boardRepository.deleteById(boardId);
    }

}
