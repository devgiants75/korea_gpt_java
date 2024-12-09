package chapter12.view;

import chapter12.controller.BookController;
import chapter12.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookView {
    // 인스턴스 변수
    private final BookController bookController;
    private final Scanner scanner;

    // 생성자
    public BookView() {
        this.bookController = new BookController();
        this.scanner = new Scanner(System.in);
    }

    // 사용자에게 메뉴를 표시하고 입력을 처리하는 메서드
    public void showMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("=== Book Management System ===");
            System.out.println("1. Add a Book");
            System.out.println("2. Show all Books");
            System.out.println("3. Search for a book");
            System.out.println("4. Quit");
            System.out.print("메뉴를 선택해주세요 : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            // 사용자의 선택에 따라 적절한 메서드 호출
            switch (choice) {
                case 1:
                    addBookView();
                    break;
                case 2:
                    showAllBooksView();
                    break;
                case 3:
                    searchBookView();
                    break;
                default:
                    System.out.println("종료하겠습니다.");
                    break;
            }
        }
    }

    private void addBookView() {
        System.out.println("책의 제목을 입력해주세요.");
        String title = scanner.nextLine();

        System.out.println("책의 저자를 입력해주세요.");
        String author = scanner.nextLine();

        System.out.println("책의 출판사를 입력해주세요.");
        String publisher = scanner.nextLine();

        bookController.addBook(title, author, publisher);
    }

    private void showAllBooksView() {
        List<Book> allBooks = bookController.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book.toString());
        }
    }

    private void searchBookView() {
        System.out.println("책을 검색해주세요.");
        String title = scanner.nextLine();
        List<Book> foundBooks = bookController.searchBook(title);
        for (Book book : foundBooks) {
            System.out.println(book.toString());
        }
    }
}