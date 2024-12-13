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
        if (isValidRequest(boardRequestDto)) {
            boardService.save(boardRequestDto);
            System.out.println("게시글이 등록되었습니다.");
        } else {
            System.out.println("입력값이 유효하지 않습니다.");
        }
    }

    public void updateBoard(long updateId, BoardRequestDto boardRequestDto) {
        if (isValidRequest(boardRequestDto)) {
            boardService.update(updateId, boardRequestDto);
            System.out.println("게시글이 수정되었습니다.");
        } else {
            System.out.println("입력값이 유효하지 않습니다.");
        }
    }

    public void deleteBoard(long deleteId) {
        try {
            boardService.delete(deleteId);
            System.out.println("게시글이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    private boolean isValidRequest(BoardRequestDto boardRequestDto) {
        boolean result = boardRequestDto.getTitle() != null && !boardRequestDto.getTitle().isEmpty()
                && boardRequestDto.getContent() != null && !boardRequestDto.getContent().isEmpty();
        return result;
    }
}