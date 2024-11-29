package chapter04;

// 클래스 생성 Book
// - 속성 3개, 메서드 1개

class Book {
    // 클래스 내부의 데이터(속성, 필드)
    String title; // 제목
    String publisher; // 출판사
    int pageNumber; // 책 페이지 수

    // 클래스 내부의 동작(행동, 메서드)
    void displayInfo() {
        System.out.println(title + " - " + publisher);
        return;
        // System.out.println("안녕하세요"); - 오류 (해당 코드는 읽히지 않음)
    }

    int returnPageNumber() {
        return pageNumber;
    }

    // === 생성자 함수 === //
    // : new 연산자 사용 시 호출 될 메서드
    // > 생략 시 속성에 기본값이 할당
    //      - 기본 타입: int(0), boolean(false), char('')
    //      - 참조 타입: null

    // +) 사용자 정의 생성자 함수 생략 시
    //      클래스명과 동일하면서 매개변수가 없는 메서드가 생략
    Book() {}

    Book(String title, String publisher, int pageNumber) {
        this.title = title;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
    }
}

public class Object04 {
    public static void main(String[] args) {
        Book myBook = new Book();
        System.out.println(myBook.title); // null
        System.out.println(myBook.publisher); // null
        System.out.println(myBook.pageNumber); // 0

        Book anotherBook = new Book("백설공주", "코리아it아카데미", 50);
        Book thirdBook = new Book("신데렐라", "에이원플라자", 100);

        System.out.println(anotherBook.title);
        System.out.println(anotherBook.pageNumber);

        System.out.println(thirdBook.publisher);
        System.out.println(thirdBook.title);

        // 메서드 호출
        anotherBook.displayInfo();
        int thirdBookPageNumber = thirdBook.returnPageNumber();
        System.out.println(thirdBookPageNumber);


        myBook.displayInfo();

        myBook.title = "개구리왕자";
        myBook.publisher = "안녕출판사";
        myBook.pageNumber = 1234;

        myBook.displayInfo();
    }
}
