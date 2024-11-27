package chapter01;

/*
* HelloWorld 파일
* - 자바 첫 출력 연습
* - 자바 주석을 설명
* */

// 자바의 파일 단위
// - 클래스 파일을 생성하여 코드 작성: 파일명 UpperCamelCase 사용
//  EX) A_Variable, B_DataType
// - 파일의 확장자: .java

// cf) UpperCamelCase
//      : 대문자로 시작, 단어와 단어의 연결은 대문자로 작성
//      : 그 외에는 소문자 작성
public class HelloWorld {
    // 자동완성 단축키: ctrl + space
    public static void main(String[] args) {
        // 출력문 자동완성 단축키: sout
        System.out.println("Hello World!");
        System.out.println("안녕하세요 만나서 반갑습니다 :)");

        // 1. 자바 주석 //
        // 단축키: ctrl(command) + /

        // 한 줄 주석: 슬래시(/) 2개
        // 여러 줄 주석
        /*
            슬래시 2개 사이에 별(*) 2개
        */

        // 2. 자바 단축키 (인텔리제이) //
        // 1) 한 줄 주석: Ctrl + /
        // 2) 여러 줄 주석: Ctrl + Shift + /

        // 3) ctrl + c, v (복붙)
        // 4) ctrl + z, y (되돌리기, 되감기)
        // 5) ctrl + x (잘라내기)

        // 6) ctrl + alt + 방향키 (한 줄 복사)
        // 7) alt + 방향키 (줄 이동)

        // 8) ctrl + f10 (실행)

    }
}
