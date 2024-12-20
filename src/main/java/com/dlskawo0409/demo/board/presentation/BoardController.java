package com.dlskawo0409.demo.board.presentation;

import com.dlskawo0409.demo.board.application.BoardService;
import com.dlskawo0409.demo.board.domain.Board;
import com.dlskawo0409.demo.board.dto.request.BoardInsertRequest;
import com.dlskawo0409.demo.board.dto.request.BoardPatchRequest;
import com.dlskawo0409.demo.board.exception.BoardException;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Tag(name = "Board", description = "공지사항 API")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardInsertRequest boardInsertRequest,
                                                   @AuthenticationPrincipal CustomMemberDetails loginMember){
        boardService.insertBoard(boardInsertRequest, loginMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getBoardList(){
        List<Board> boardList = boardService.findIsNotDeleted();
        return ResponseEntity.ok(boardList);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<?> modifyBoard(@PathVariable("boardId") Long boardId,
                                                @RequestBody BoardPatchRequest boardPatchRequest) throws BoardException.BoardBadRequestException {
        boardService.patchBoard(boardId, boardPatchRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
