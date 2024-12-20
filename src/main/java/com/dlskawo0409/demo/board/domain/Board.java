package com.dlskawo0409.demo.board.domain;

import com.dlskawo0409.demo.common.domain.BasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Board extends BasicEntity {
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

}
