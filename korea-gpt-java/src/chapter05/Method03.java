package chapter05;

// 사칙연산 클래스
// : 두 개의 값을 매개변수로 전달받아 사칙연산 수행
class MyMath {
    // 매개변수 O, 반환값 O
    int add(int a, int b) {
        return a + b;
    }
    int subtract(int a, int b) {
        return a - b;
    }
    int multiply(int a, int b) {
        return a * b;
    }
    int divide(int a, int b) {
        if (b == 0) {
            System.out.println("정수 0으로 나눌 수 없습니다.");
            return b;
        } else {
            return a / b;
        }
    }

    // cf) return 문
    //      : 현재 실행중인 메서드를 종료하고 호출한 메서드로 돌아감
    //      > 반환값 유무에 상관없이 반드시 존재!

    void noReturn() {
        System.out.println("해당 메서드는 반환값이 없습니다.");

        // return;
        // : 자바 컴파일러가 반환 타입을 읽고
        //      해당 메서드의 마지막에 자동으로 return;을 추가
    }

    String yesReturn() {
        String name = "이승아";
        return name;
        // : 반환 타입이 void가 아닌 경우 반드시 해당 타입의 값이 return 뒤에 작성!
    }

    // 조건에 따른 반환값 지정
    int max(int a, int b) {
        // 정수 a와 b를 비교하여
        // : a가 큰 경우 a값을 반환
        // : b가 큰 경우 b값을 반환
        if (a > b) return a;
        else return b;
    }

    int min(int a, int b) {
        // return 문 뒤에 삼항 연산자를 사용하여 최솟값을 반환
        return a < b ? a : b;

        // return a > b ? b : a;
    }
}

public class Method03 {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();

        System.out.println(myMath.add(10, 20));
        // cf) 인자값과 매개변수의 관계
        //      : 자바는 값에 의한 호출 방식을 사용
        //      - 메서드 호출 시 인자값이 "매개변수에 복사"되어 전달

        // System.out.println(myMath.divide(10, 0)); // / by zero
        // : 자바에서는 정수형에서 0으로 나누기를 시도하면 Exception가 발생
        // cf) 실수형 연산(0.0으로 나누기)에서는 오류가 나지 X
        myMath.divide(10, 0); // 정수 0으로 나눌 수 없습니다.
        System.out.println(myMath.divide(10, 5)); // 2

        // 메서드의 호출: 객체명.메서드명(인자);
        System.out.println(myMath.max(11, 12)); // 12
        System.out.println(myMath.min(11, 12)); // 11
    }
}
