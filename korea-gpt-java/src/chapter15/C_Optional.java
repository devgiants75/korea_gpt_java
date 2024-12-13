package chapter15;

import java.util.Optional;
/*
* === Optional 클래스 ===
* : 값이 존재할 수도 있고 없을 수도 있는 객체를 감싸는 컨테이너, 자바 8에서 추가된 기능
* - null값을 다룰 때 발생하는 NullPointerException(NPE) 문제를 줄이고
*   , 명시적으로 값의 유무를 처리하도록 설계
* */

// 1. Optional 클래스
// : null이 아닌 값을 포함하거나, 값이 없는 상태를 나타낼 수 있음
// - 값을 명시적으로 검사하고 처리하는 방식
// - 코드의 안정성과 가독성을 높임

// 2. Optional 생성 방법
// .of() 메서드
// : null이 아닌 값을 감싸는 메서드
// - null값을 전달하면 NullPointerException(NPE)을 발생시킴

// .ofNullable() 메서드
// : null일 수도 있는 값을 감싸는 메서드
// : null값이 들어오면 빈 Optional 객체를 반환

// .empty() 메서드
// : 빈 Optional 객체를 생성

public class C_Optional {
    public static void main(String[] args) {
        // .of() 메서드
        Optional<String> optional1 = Optional.of("Hello Optional");
        // Optional<String> optional2 = Optional.of(null);

        // .ofNullable() 메서드
        Optional<String> optional2 = Optional.ofNullable(null);

        // .empty() 메서드
        Optional<String> optional3 = Optional.empty();

        // 3. Optional 주요 메서드
        // 1) 값이 있는지 확인
        // : isPresent() - 있으면 true, 없으면 false
        //      & isEmpty() - 있으면 false, 없으면 true

        System.out.println(optional1.isPresent()); // true
        System.out.println(optional1.isEmpty()); // false

        System.out.println(optional2.isPresent()); // false
        System.out.println(optional2.isEmpty()); // true

        // 2) 값 가져오기
        // : .get()
        // : 값이 있을 경우 값 반환, 없을 경우 NoSuchElementException 발생
        System.out.println(optional1.get()); // Hello Optional
        // System.out.println(optional2.get()); - NoSuchElementException

        // 3) 기본값 처리
        // : .orElse() - 값이 없으면 기본값 반환
        // : .orElseGet() - 값이 없으면 함수형 인터페이스로 값을 생성
        // : .orElseThrow() - 값이 없으면 예외를 발생

        System.out.println(optional2.orElse("기본값"));
        System.out.println(optional2.orElseGet(() -> "발생 시키는 값"));

        try {
            System.out.println(optional2.orElseThrow(() -> new Error("비워질 경우 사용자 정의 예외 발생")));
        } catch (Error e) {
            System.out.println("예외가 발생했음!"); // 예외가 발생했음!
        }

        // +) 스트림 활용 가능!
        //      : Optional 객체는 스트림으로 변환 가능!

        // +) Optional 사용 시 주의점
        // - 모든 곳에 Optional을 사용할 필요는 없음!
        //      : 반환 값에만 사용하는 것을 권장
        //      - 필드 & 매개변수로 사용 X
        // - 값이 반드시 있어야 하는 경우 Optional 사용 X
        //      : null 방지에 대한 필수 값은 직접 값을 반환하고 null 여부 확인

    }
}
