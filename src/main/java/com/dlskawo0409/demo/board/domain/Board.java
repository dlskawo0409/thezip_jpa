package com.dlskawo0409.demo.board.domain;

import com.dlskawo0409.demo.board_comment.domain.BoardComment;
import com.dlskawo0409.demo.common.domain.BasicEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String author;
    private Integer views;

    @Setter
    @Embedded
    private BasicEntity basicEntity;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    List<BoardComment> boardComments;

}
