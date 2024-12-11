package chapter14;

// 람다 표현식 (Lambda Expression)
// : 함수형 인터페이스 구현에 사용, 자바 8에서 도입된 기능
// - 간결성, 함수형 프로그래밍의 지원 등의 특징
// - 익명 클래스를 대체하여 코드의 가독성 향상에 기여

// cf) 함수형 인터페이스
//      : 단 하나의 추상 메서드만 가지는 인터페이스
//      : @FunctionalInterface 어노테이션
//      - 디폴트 메서드, 정적 메서드는 포함 가능

// 1. 람다식 기본 형태
// : (params) -> { 실행문 }

// 1) 매개변수: 함수형 인터페이스에서 메서드와 동일한 매개변수를 사용
// 2) 화살표 연산자(->): 매개변수와 실행문(바디)을 구분
// 3) 바디: 메서드의 구현부({}, 코드블럭)

// cf) 일반 메서드(함수)
// 반환타입 메서드명(params) { 실행문 }

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething(); // 추상 메서드
    // void anotherDoSomething();
    // : @FunctionalInterface는 하나의 추상 메서드만 가짐
}

// === 람다식 사용 예제 === //

// 1) 기본 표현: 여러 개의 매개변수, 하나의 실행문
interface Calculator {
    int add(int a, int b);
}

// 2) 매개변수가 없는 경우
@FunctionalInterface
interface NoParams {
    void sayHello();
}

// 3) 매개변수가 한 개인 경우: 소괄호 생략 가능
@FunctionalInterface
interface OneParam {
    void print(String message);
}

// 4) 실행문이 여러 줄인 경우: 중괄호 작성
@FunctionalInterface
interface Operation {
    void operation(int a, int b);
}

// 5) 반환값이 있는 경우
@FunctionalInterface
interface StringLength {
    int getLength(String str);
}

public class D_Lambda {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("안녕");
        myFunctionalInterface.doSomething(); // 안녕

        // 익명 클래스 방식 (3, 5)
        Calculator calculator1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println("익명 클래스 결과: " + calculator1.add(3, 5));

        // 람다식 방식
        // 1) 기본 방식
        Calculator calculator2 = (a, b) -> a + b;
        System.out.println("람다식 결과: " + calculator2.add(3, 5));

        // 2) 매개변수가 없는 방식
        NoParams noParams = () -> System.out.println("안녕하세요");
        noParams.sayHello();

        // 3) 매개변수가 한 개인 방식
        OneParam oneParam = message -> System.out.println("출력 메시지: " + message);
        oneParam.print("안녕");

        // 4) 출력문이 여러 줄인 방식
        Operation operation = (a, b) -> {
            System.out.println("합: " + (a + b));
            System.out.println("차: " + (a - b));
        };
        operation.operation(1, 2);
//        합: 3
//        차: -1

        // 5) 반환값이 있는 경우
        StringLength stringLength = str -> str.length();
        System.out.println("문자열 길이:  " + stringLength.getLength("Lambda")); // 문자열 길이:  6

        // cf) 여러 줄의 코드가 실행문에 작성될 경우 return 필요

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers); // [1, 2, 3]

        // for-each문
        for (Integer num : numbers) {
            System.out.println(num);
        }

        // 입력 값을 받아 소비(출력 & 상태 변경)하는 데 사용
        numbers.forEach(num -> System.out.println(num));
    }
}
