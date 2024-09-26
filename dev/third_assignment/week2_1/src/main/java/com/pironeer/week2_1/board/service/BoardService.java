package com.pironeer.week2_1.board.service;

import com.pironeer.week2_1.global.dto.response.result.ListResult;
import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import com.pironeer.week2_1.global.service.ResponseService;
import com.pironeer.week2_1.board.dto.request.BoardCreateRequest;
import com.pironeer.week2_1.board.dto.request.BoardUpdateRequest;
import com.pironeer.week2_1.board.dto.response.BoardResponse;
import com.pironeer.week2_1.board.mapper.BoardMapper;
import com.pironeer.week2_1.board.repository.BoardMemoryRepository;
import com.pironeer.week2_1.board.entity.Board;
import com.pironeer.week2_1.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<Long> save(BoardCreateRequest request) {
        Board savedBoard = boardRepository.save(BoardMapper.from(request));
        return ResponseService.getSingleResult(savedBoard.getId());
    }

    public SingleResult<BoardResponse> findById(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        BoardResponse boardResponse = board != null ? BoardResponse.of(board) : null;
        return ResponseService.getSingleResult(boardResponse);
    }

    public ListResult<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> list = boards.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id()).orElse(null);
        if (board != null) {
            boardRepository.save(board.update(request));
            return BoardResponse.of(board);
        }
        return null;
    }

    public Long deleteById(Long id) {
        Long deleteId = boardRepository.deleteById(id);
        return deleteId;
    }
}


