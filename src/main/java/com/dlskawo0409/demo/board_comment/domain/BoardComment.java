package com.dlskawo0409.demo.board_comment.domain;

import com.dlskawo0409.demo.board.domain.Board;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Builder
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentId;

    @ManyToOne
    Board board;

    @Setter
    String content;

    @Setter
    String author;
}
