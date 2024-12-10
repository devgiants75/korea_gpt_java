package chapter13.practice.controller;

import chapter13.practice.model.Book;
import chapter13.practice.service.BookServiceImpl;
import chapter13.practice.view.BookView;

import java.util.List;

public class BookController {
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInput();

            switch (choice) {
                case 1:
                    service.addBook(view.getBookDetails());
                    break;
                case 2:
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 3:
                    Book book = service.findBookById(view.getInput());
                    view.displayBook(book);
                    break;
                case 4:
                    int id = view.getInput();
                    if (id != -1) {
                        Book updatedBook = view.getBookDetails();
                        if (updatedBook != null) {
                            service.updateBook(id, updatedBook);
                        } else {
                            System.out.println("도서 정보가 유효하지 않습니다.");
                        }
                    } else {
                        System.out.println("유효하지 않은 ID입니다.");
                    }
                    break;
                case 5:
                    service.removeBook(view.getInput());
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
