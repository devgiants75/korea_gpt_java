package chapter15.boardApp.controller;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;
import chapter15.boardApp.entity.Board;
import chapter15.boardApp.service.BoardService;
import chapter15.boardApp.service.BoardServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class BoardController {
    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardServiceImpl();
    }

    public void getAllBoards() {
        List<BoardResponseDto> boards = boardService.findAll(); // 요청

        if (boards.isEmpty()) {
            System.out.println("게시글이 없습니다.");
        } else {
            boards.forEach(System.out::println); // 응답
        }
    }

    public void getBoardById(long id) {
        try {
            BoardResponseDto boardResponseDto = boardService.findById(id); // 요청
            System.out.println(boardResponseDto); // 응답
        } catch(IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    public void createBoard(BoardRequestDto boardRequestDto) {
    }

    public void updateBoard(long updateId, BoardRequestDto boardRequestDto) {
    }

    public void deleteBoard(long deleteId) {
    }
}
