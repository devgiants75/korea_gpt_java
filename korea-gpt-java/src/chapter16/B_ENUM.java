package chapter16;

/*
* ===== ENUM (열거형) =====
* : 서로 관련된 상수들의 집합을 표현하는 데 사용하는 자료형
* - 서로 유기적인 관계성의 띄며, 자바의 클래스처럼 취급
* - 일반적으로 상수 선언에 사용되는 static final 보다 더 간결하고 안전한 방식으로 정의
* - 특정 값들만 가질 수 있도록 제한하는 데 사용
* */

// Enum의 기본 사용법
// : enum Enum명 { }
// - Enum 명명은 대문자로 시작 UpperCamelCase 사용
// - 중괄호 내에 열거할 데이터를 ,로 구분하여 나열

// cf) class 사용법: class Class명 { }

enum Fruits {
    // enum 내의 데이터는 final 특징을 살려 UPPER_SNAKE_CASE 사용
    APPLE, BANANA, ORANGE
}

enum CoffeeSize {
    SMALL(200), MEDIUM(300), LARGE(400); // 생성자 호출

    private final int ml;

    CoffeeSize(int ml) {
        this.ml = ml;
    }

    public int getMl() { return ml; }
}

public class B_ENUM {
    public static void main(String[] args) {
        // 클래스의 static final 필드 처럼 쓰임
        // - 각 상수는 정의된 Enum 타입으로 간주
        Fruits apple = Fruits.APPLE;
        System.out.println(apple); // APPLE

        // === Enum의 주요 메서드 ===
        // 1) values(): 열거형의 모든 값을 배열로 반환
        System.out.println(Fruits.values()); // [Lchapter16.Fruits;@5aaa6d82

        // cf) Enum 순환
        for (Fruits fruits : Fruits.values()) {
            System.out.println(fruits);
//            APPLE
//            BANANA
//            ORANGE
        }

        // 2) name(): Enum 상수의 이름을 문자열로 반환
        String appleName = Fruits.APPLE.name();
        System.out.println(appleName); // APPLE

        // 3) ordinal(): Enum 상수의 순서를 반환 (0부터 시작)
        // 4) valueOf(String name): 문자열로 Enum 상수를 반환
        //          - 잘못된 문자열 전달 시 IllegalArgumentException 발생

        // Fruits orangeFruits = Fruits.valueOf("Orange"); // IllegalArgumentException
        Fruits orangeFruits = Fruits.valueOf("ORANGE");
        System.out.println(orangeFruits.ordinal()); // 2


        // === CoffeeSize 자료형 사용 === //
        CoffeeSize size = CoffeeSize.MEDIUM;
        System.out.println("Selected size: " + size + ", Volume: " + size.getMl() + "ml");
        // Selected size: MEDIUM, Volume: 300ml
    }
}
