package com.dlskawo0409.demo.board_comment.presentation;

import com.dlskawo0409.demo.board.exception.BoardException;
import com.dlskawo0409.demo.board_comment.application.BoardCommentService;
import com.dlskawo0409.demo.board_comment.domain.BoardComment;
import com.dlskawo0409.demo.board_comment.dto.request.BoardCommentInsertRequest;
import com.dlskawo0409.demo.board_comment.dto.request.BoardCommentPatchRequest;
import com.dlskawo0409.demo.board_comment.exception.BoardCommentException;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import com.dlskawo0409.demo.member.exception.MemberException;
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
@RequestMapping("/boards/comments")
@Tag(name = "Board Comments", description = "게시판 댓글 API")
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    @PostMapping
    public ResponseEntity<?> createBoardComment(@RequestBody BoardCommentInsertRequest boardCommentInsertDTO,
                                                        @AuthenticationPrincipal CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException {
        boardCommentService.insertBoardComment(boardCommentInsertDTO,loginMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoardComment(@PathVariable("boardId") Long boardId) throws BoardException.BoardBadRequestException {
        List<BoardComment> boardCommentList = boardCommentService.getBoardCommentByBoardId(boardId);
        return ResponseEntity.ok(boardCommentList);
    }

    @PatchMapping("/{boardCommentId}")
    public ResponseEntity<?> patchBoardComment(@PathVariable("boardCommentId") Long boardId,
                                               @RequestBody BoardCommentPatchRequest boardCommentPatchRequest) throws BoardCommentException.BoardCommentBadRequestException {
        boardCommentService.patchBoardComment(boardId, boardCommentPatchRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{boardCommentId}")
    public ResponseEntity<?> deleteBoardCommentController(@PathVariable("board-comment-id") Long boardCommentId,
                                                          @AuthenticationPrincipal CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException, BoardException.BoardBadRequestException {
        boardCommentService.deleteBoardComment(boardCommentId, loginMember);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
