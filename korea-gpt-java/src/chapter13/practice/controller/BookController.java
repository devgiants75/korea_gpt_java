package chapter13.practice.controller;

import chapter13.practice.model.Book;
import chapter13.practice.service.BookServiceImpl;
import chapter13.practice.view.BookView;

import java.util.List;

// 사용자의 요청을 처리
public class BookController {
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInput(); // 숫자 값을 검증하여 가져오는 메서드

            switch (choice) {
                case 1: // 책 추가: 요청 데이터 O, 반환 데이터 X
                    Book book = view.getBookDetails();
                    if (book != null) service.addBook(book);
                    else System.out.println("책은 장르 또는 필드값이 필수입니다.");
                    break;
                case 2: // 전체 책 조회: 요청 데이터 X, 반환 데이터 O
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 3: // 단건 책 조회: 요청 데이터 O, 반환 데이터 O
                    int findBookId = view.getInput(); // 검색하고자 하는 Book의 id
                    if (findBookId != -1) {
                        Book findBook = service.findBookById(findBookId); // 해당 id로 찾은 Book 객체
                        view.displayBook(findBook); // 객체 반환
                    } else {
                        System.out.println("유효하지 않은 ID입니다.");
                    }
                    break;
                case 4: // 책 수정: 요청 데이터 O, 반환 데이터 X
                    int modifiedId = view.getInput();
                    if (modifiedId != -1) {
                        Book updatedBook = view.getBookDetails();
                        if (updatedBook != null) {
                            service.updateBook(modifiedId, updatedBook);
                        } else {
                            System.out.println("도서 정보가 유효하지 않습니다.");
                        }
                    } else {
                        System.out.println("유효하지 않은 ID입니다.");
                    }
                    break;
                case 5:
                    int removedId = view.getInput();

                    if (removedId != -1) service.removeBook(removedId);
                    else System.out.println("유효하지 않은 ID입니다.");

                    break;
                case 0:
                    System.out.println("=== 프로그램 종료 ===");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}