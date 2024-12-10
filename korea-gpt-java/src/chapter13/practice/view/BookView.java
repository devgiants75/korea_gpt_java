package chapter13.practice.view;

import chapter13.practice.model.Book;
import chapter13.practice.model.Fiction;
import chapter13.practice.model.NonFiction;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("==========================");
        System.out.println("도서 관리 시스템");
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 전체 조회");
        System.out.println("3. 도서 단건 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("0. 종료");
        System.out.print("선택 >>>");
    }

    // 사용자 입력값에 대한 유효성 검증 로직 추가
    public int getInput() {
        int choice;

        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            scanner.nextLine();
            return -1;
        }

        return choice;
    }

    public Book getBookDetails() {
        System.out.println("도서 ID: ");
        int id = getInput();
        if (id == -1) return null;

        scanner.nextLine();

        System.out.println("제목: ");
        // cf) 문자열 메서드 - 문자열.trim()
        //      : 문자열 양 끝의 공백을 제거
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("제목은 비어 있을 수 없습니다.");
            return null;
        }

        System.out.println("저자: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("저자는 비어 있을 수 없습니다.");
            return null;
        }

        System.out.println("1. Fiction / 2. NonFiction");
        int type = getInput();
        if (type == -1) return null;
        scanner.nextLine();

        if (type == 1) {
            System.out.println("장르: ");
            String genre = scanner.nextLine().trim();
            if (genre.isEmpty()) {
                System.out.println("장르는 비어 있을 수 없습니다.");
                return null;
            }
            return new Fiction(id, title, author, genre);
        } else if (type == 2) {
            System.out.println("분야: ");
            String field = scanner.nextLine().trim();
            if (field.isEmpty()) {
                System.out.println("분야는 비어 있을 수 없습니다.");
                return null;
            }
            return new NonFiction(id, title, author, field);
        } else {
            System.out.println("잘못된 선택입니다. 1 또는 2를 입력하세요.");
            return null;
        }
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (Book book : books) {
                book.toString();
            }
        }
    }

    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            book.toString();
        }
    }
}
