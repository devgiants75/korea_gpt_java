package chapter15.boardApp.repository;

import chapter15.boardApp.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardRepository {
    // DB를 대신하여 게시글을 저장할 리스트
    private final List<Board> boardStorage = new ArrayList<>();
    private long idSequence = 1;

    public List<Board> findAll() {
        return new ArrayList<>(boardStorage);
    }

    public Optional<Board> findById(long id) {
        // findFirst() 메서드
        // : Stream에서 조건에 맞는 첫 번째 요소를 반환하기 위해 사용
        // - id가 해당 객체의 고유값이라면, 더 정확하게 해당 객체를 가져오는 방법
        // - Optional 타입의 객체를 반환
        return boardStorage.stream()
                .filter(board -> board.getId() == id).findFirst();
    }
}
