package com.dlskawo0409.demo.board_comment.application;

import com.dlskawo0409.demo.board.domain.Board;
import com.dlskawo0409.demo.board.domain.BoardRepository;
import com.dlskawo0409.demo.board.exception.BoardErrorCode;
import com.dlskawo0409.demo.board.exception.BoardException;
import com.dlskawo0409.demo.board_comment.domain.BoardComment;
import com.dlskawo0409.demo.board_comment.domain.BoardCommentRepository;
import com.dlskawo0409.demo.board_comment.dto.request.BoardCommentInsertRequest;
import com.dlskawo0409.demo.board_comment.dto.request.BoardCommentPatchRequest;
import com.dlskawo0409.demo.board_comment.exception.BoardCommentErrorCode;
import com.dlskawo0409.demo.board_comment.exception.BoardCommentException;
import com.dlskawo0409.demo.member.domain.Member;
import com.dlskawo0409.demo.member.domain.MemberRepository;
import com.dlskawo0409.demo.member.domain.Role;
import com.dlskawo0409.demo.member.dto.request.CustomMemberDetails;
import com.dlskawo0409.demo.member.exception.MemberErrorCode;
import com.dlskawo0409.demo.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardCommentService {

    private final BoardCommentRepository boardCommentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public void insertBoardComment(BoardCommentInsertRequest boardCommentInsertRequest,
                                                                CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException {
        Member member = memberRepository.findById(loginMember.getMemberId())
                .orElseThrow(() -> new MemberException.MemberBadRequestException(MemberErrorCode.MEMBER_NOT_FOUND));

        BoardComment boardComment = BoardComment.builder()
                .content(boardCommentInsertRequest.content())
                .author(member.getNickname())
                .build();

        boardCommentRepository.save(boardComment);
    }
    public List<BoardComment> getBoardCommentByBoardId(Long boardId) throws BoardException.BoardBadRequestException {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardException.BoardBadRequestException(BoardErrorCode.BOARD_NOT_FOUND));

        return board.getBoardComments();
    }

    @Transactional
    public void patchBoardComment(Long boardCommentId, BoardCommentPatchRequest boardCommentPatchRequest) throws BoardCommentException.BoardCommentBadRequestException {
        BoardComment boardComment = boardCommentRepository.findById(boardCommentId)
                .orElseThrow(()-> new BoardCommentException.BoardCommentBadRequestException(BoardCommentErrorCode.BOARD_COMMENT_NOT_FOUND));

        if(boardCommentPatchRequest.content() != null){
            boardComment.setContent(boardComment.getContent());
        }

        if(boardCommentPatchRequest.author() != null){
            boardComment.setAuthor(boardComment.getAuthor());
        }
    }

    @Transactional
    public void deleteBoardComment(Long boardCommentId, CustomMemberDetails loginMember) throws MemberException.MemberBadRequestException, BoardException.BoardBadRequestException {

        String role = loginMember.getAuthorities().iterator().next().getAuthority();
        BoardComment boardComment = boardCommentRepository.findById(boardCommentId)
                .orElseThrow(()-> new BoardException.BoardBadRequestException(BoardErrorCode.BOARD_NOT_FOUND));
        if(!(role.equals(Role.ADMIN.getKey()) || Objects.equals(loginMember.getMember().getNickname(), boardComment.getAuthor()))){
            throw new MemberException.MemberBadRequestException(MemberErrorCode.ILLEGAL_ROLE);
        }
        boardCommentRepository.delete(boardComment);
    }


}
