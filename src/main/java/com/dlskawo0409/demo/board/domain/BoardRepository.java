package com.dlskawo0409.demo.board.domain;

import com.dlskawo0409.demo.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByDeletedAtIsNull();
}
