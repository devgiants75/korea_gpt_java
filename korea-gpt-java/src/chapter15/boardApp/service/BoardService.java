package chapter15.boardApp.service;

import chapter15.boardApp.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    List<BoardResponseDto> findAll();
    BoardResponseDto findById(long id);
}
