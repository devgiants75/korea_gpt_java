package chapter15.boardApp.dto;

import chapter15.boardApp.entity.Board;
import lombok.Getter;
import lombok.ToString;

/*
* BoardDto
* : DB의 게시판 데이터 중 사용자에게 응답으로 전달할 객체 구조
* - content 값을 제외한 필드를 제공
* */
@Getter
@ToString
public class BoardResponseDto {
    private long id;
    private String title;
    private String author;

    public static BoardResponseDto fromEntity(Board board) {
        return new BoardResponseDto(board);
    }

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }
}