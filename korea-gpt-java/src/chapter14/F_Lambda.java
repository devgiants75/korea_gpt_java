package chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// 메서드 참조(:: 연산자)
// : 람다 표현식을 더 간결하게 작성할 수 있도록 지원하는 문법
// : 단순히 메서드 호출만 하는 경우

// 1. 정적 메서드 참조 (ClassName::staticMethod)
// 2. 인스턴스 메서드 참조 (instance::instanceMethod)
// 3. 생성자 참조(ClassName::new)
// 4. 임의 객체 인스턴스 메서드 참조 (ClassName::instanceMethod)

public class F_Lambda {
    public static void main(String[] args) {
        String string = "Hello";

        Supplier<String> toUpperLambda = () -> string.toUpperCase();

        Supplier<String> toUpperMethodRef = string::toUpperCase;

        System.out.println(toUpperLambda.get()); // HELLO
        System.out.println(toUpperMethodRef.get()); // HELLO
    }
}
