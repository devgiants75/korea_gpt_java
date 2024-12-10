package chapter13;

// === 빌더(Builder) 패턴 === //

// 1. 빌더 패턴이란?
// : 객체 생성 방법 중 하나
// : 복잡한 객체를 단계별로 만들 때 사용
// - 필드(속성)가 많거나, 필수 값과 선택 값이 섞여 있을 때 유용

// 2. 빌더 패턴의 장단점
// 1) 장점
//      - 가독성 향상, 유연성 증가, 확장성 용이
// 2) 단점
//      - 구현 복잡성 증가, 작은 객체에는 부적합

// 3. 빌더 패턴 사용
// - 생성자가 너무 많아질 때
// - 코드가 복잡하고 읽기 어려울 때

// 4. 빌더 패턴의 동작 원리
// 1) 객체를 생성하는 데 필요한 데이터를 저장하는 Builder 클래스를 생성
// 2) Builder 클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드를 제공
// 3) build() 메서드를 호출하여 객체 생성

class Pizza {
    private final String menu; // 종류
    private final String size; // 크기

    private final boolean cheese; // 선택
    private final boolean mushrooms; // 선택
    private final boolean pepperoni;

//    public Pizza(String menu, String size, boolean cheese, boolean mushrooms, boolean pepperoni) {
//        this.menu = menu;
//        this.size = size;
//        this.cheese = cheese;
//        this.mushrooms = mushrooms;
//        this.pepperoni = pepperoni;
//    }

    public static class Builder {
        private final String menu;
        private final String size;

        // 선택적 필드 - 기본값 설정이 되어 있음 (추가하지 않으면 지정)
        private boolean cheese = false;
        private boolean mushrooms = false;
        private boolean pepperoni = false;

        public Builder(String menu, String size) {
            // 필수 값 설정
            this.menu = menu;
            this.size = size;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }
        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }
        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.cheese = builder.cheese;
    }
}

public class E_Builder {
    public static void main(String[] args) {
        // Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", false, false, false);

        Pizza builderPizza = new Pizza.Builder("고구마 피자", "M")
                .build();

        Pizza pizza1 = new Pizza.Builder("포테이토 피자", "L")
                .addCheese()
                .build();

        Pizza pizza2 = new Pizza.Builder("쉬림프 피자", "L")
                .addPepperoni()
                .addMushrooms()
                .build();
    }
}
