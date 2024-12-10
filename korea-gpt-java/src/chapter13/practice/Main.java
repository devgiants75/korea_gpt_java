package chapter13.practice;

/*
* MVC 패턴 도서 관리 시스템
*
* @Model
*   Book 클래스 (부모)
*   Fiction, NonFiction 클래스 (자식)
*
* @View
*   사용자에게 정보를 출력하거나 입력받는 역할
*
* @Controller
*   사용자 요청을 처리하고 비즈니스 로직을 실행
*
* @Service(Business Logic)
*   싱글톤으로 구현, CRUD 로직 포함
*
* @Repository
*   데이터 저장소 역할
*
* */

import chapter13.practice.controller.BookController;

// cf) 비즈니스 로직(Business Logic)
//      : 프로그램에서 요구하는 요청의 처리나 특정 기능 수행을 위해 데이터를 처리하는 실질적인 로직
public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.start();
    }
}
