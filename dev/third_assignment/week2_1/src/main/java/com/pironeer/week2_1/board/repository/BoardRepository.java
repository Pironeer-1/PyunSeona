package com.pironeer.week2_1.board.repository;

import com.pironeer.week2_1.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);

    Optional<Board> findById(Long id);

    List<Board> findAll();

    Long deleteById(Long id);
}

