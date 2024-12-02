package chapter05;

// === 정적 메서드 ===

// cf) 클래스의 "필드"
//      : 인스턴스 필드 VS 정적(클래스, static) 필드

// 클래스의 "메서드"
//      : 인스턴스 메서드 VS 정적 메서드
// - 인스턴스 메서드: 객체(인스턴스)를 생성한 후 호출할 수 있는 메서드
// - 정적(static) 메서드: 객체 생성 없이 호출 가능한 메서드

// 1. 정적 메서드란?
//  : static 키워드를 메서드 앞에 붙여 정의된 메서드
//  : 클래스 이름으로 직접 호출 가능

// 2. 정적 메서드 사용법
// - static 반환타입 메서드명() {}
// - 클래스명.메서드명();

// 3. 정적 메서드의 특징
// - 인스턴스 변수에 의존하지 X
// - 클래스 수준에서 공유되는 데이터를 다룰 때 적합

// 4. 정적 메서드 사용 권장 사항
// 1) 공통 데이터 사용: 모든 인스턴스에서 공유되는 데이터를 다룰 때
// 2) 독립적인 사용: 인스턴스 변수와 관계없이 매개변수만으로 작업을 처리할 때

class Operator {
    // (인스턴스) 변수(필드)
    int a, b;

    // (인스턴스) 메서드
    // : 인스턴스 변수 a, b가 필요한 작업
    // > 매개변수가 필요하지 않은 경우가 있음.

    int add() {
        return a + b;
    }

    int subtract() {
        return a - b;
    }

    // 정적 메서드
    // : 인스턴스 변수와 관계없이 매개변수만으로 작업
    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return b != 0 ? a / b : b;
    }
}

public class Method04 {
    public static void main(String[] args) {

        System.out.println("=== 인스턴스 메서드 ===");

        Operator operator = new Operator();

        operator.a = 10;
        operator.b = 20;

        System.out.println(operator.add()); // 30
        System.out.println(operator.subtract()); // -10

        System.out.println("=== 정적 메서드 ===");
        // 정적(클래스, static) 메서드 호출
        // : 클래스명.메서드명(인자...);
        int result1 = Operator.multiply(10, 20);
        int result2 = Operator.divide(20, 10);
        int result3 = Operator.divide(20, 0);

        System.out.println(result1); // 200
        System.out.println(result2); // 2
        System.out.println(result3); // 0
    }
}
