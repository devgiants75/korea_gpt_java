package chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        // switch 조건문
        // : 특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정
        // : 비교할 변수와 case 값을 비교하여 같은 값일 경우
        //      , 해당 블록부터 끝까지 실행
        // - break 키워드에서 switch 문이 종료

        /*
        switch (조건변수) {
            case 조건값1:
                실행 문장;
                break;
            case 조건값2:
                실행 문장;
                break;
            case 조건값...:
                실행 문장...;
                break;
            default:
                case 조건식이 끝난 뒤 작성
                : 어느 case에도 일치하지 않을 경우
        }
        */

        Scanner sc = new Scanner(System.in);

        System.out.println("Chapter를 선택하세요.");
        int chapter = sc.nextInt();

        switch (chapter) {
            case 1:
                System.out.println("자바 기본 문법");
                break;
            case 2:
                System.out.println("자바 제어문 - 조건문/반복문");
                break;
            case 3:
                System.out.println("자바 배열");
                break;
            default:
                System.out.println("유효한 Chapter가 아닙니다.");
        }

        sc.nextLine(); // nextInt() 뒤의 개행 문자를 처리

        System.out.println("과일을 입력하세요");
        String fruit = sc.nextLine();
        switch (fruit) {
            case "banana":
                System.out.println("바나나는 노랗다.");
                break;
            case "strawberry":
                System.out.println("딸기는 빨갛다.");
                break;
            case "grape":
                System.out.println("포도는 보라색이다.");
                break;
            default:
                System.out.println("유효한 과일이아닙니다.");
        }

        sc.close();
    }
}
