package com.dlskawo0409.demo.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByBasicEntity_DeletedAtIsNull();
}
