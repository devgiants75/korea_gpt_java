package chapter15.boardApp.service;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    List<BoardResponseDto> findAll();
    BoardResponseDto findById(long id);
    void save(BoardRequestDto boardRequestDto);
    void update(long id, BoardRequestDto boardRequestDto);
    void delete(long id);
}
