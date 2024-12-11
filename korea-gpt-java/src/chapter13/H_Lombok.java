package chapter13;

// Lombok(롬복) 라이브러리
// : 보일러플레이트 코드를 줄여주는 라이브러리
// - 어노테이션을 사용하여 코드를 간결하게 만들어 줌

// cf) 보일러플레이트 코드: 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화 된 코드

// 1. @Getter / @Setter 어노테이션
// : 필드에 대한 getter와 setter 메서드를 자동으로 생성

// 2. @ToString 어노테이션
// : 클래스의 toString() 메서드를 자동으로 구현
// - sout에 객체를 출력하는 경우 아래와 같이 출력
// - 클래스명(필드명1=필드값1,필드명2=필드값2)

// 3. 생성자 어노테이션
// cf) 매개변수 - parameter(params), 인자(인수) - argument(args)

// 1) @NoArgsConstructor: 기본 생성자
// 2) @RequiredArgsConstructor: 필수 필드 생성자
// 3) @AllArgsConstructor: 전체 필드 생성자

// 4. @Data 어노테이션
// : @Setter, @Getter, @ToString, @RequiredConstructor, @EqualsAndHashCode 어노테이션을
//      한번에 적용하는 어노테이션

// 5. @Builder 어노테이션
// : 복잡한 객체를 생성할 때 사용하는 빌더 패턴을 자동으로 구현
// - @Builder 어노테이션을 사용하는 빌더 패턴의 경우
//      필드 값을 모두 메서드 체이닝으로 가져옴
// - 클래스명.builder().build();
//      : 필수값을 builder()메서드의 인자로 받지 X
//      : 메서드 체이닝 내에서 누락 시 오류

import lombok.*;
// import lombok.Getter;
// import lombok.Setter;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
@Data
//// @NoArgsConstructor
@AllArgsConstructor
@Builder
class LombokClass {
    // 필드에 필수값을 지정
    // : null 값이 들어갈 수 없음!

    // cf) (필드) final 키워드 - 참조 데이터 타입의 기본값으로 null이 포함 가능
    @NonNull
    private final String title;
    private String author;

//    public String getTitle() { return title; }
//    public String getAuthor() { return author; }

    // toString 메서드
    // : Object 객체 클래스 내의 메서드
    // - 클래스 내의 데이터의 문자열 출력을 담당
//    @Override
//    public String toString() {
//        return "Title: " + title +  ", Author: " + author;
//    }

//    LombokClass(String title) {
//        this.title = title;
//    }

    // Builder 클래스
    // : 프로젝트 전역적인 접근이 가능
//    public static class Builder {
//        private final String title;
//        private String author = "작가 미상";
//
//        // 빌더 클래스의 인자 - 필수 필드값
//        public Builder(String title) {
//            this.title = title;
//        }
//
//        // 선택 필드값 설정을 위한 메서드
//        public Builder author(String author) {
//            this.author = author;
//            return this;
//        }
//
//        // 만들어진 Builder의 인스턴스를 LombokClass에 전달하는 build 메서드
//        public LombokClass build() {
//            return new LombokClass(this);
//        }
//    }
//
//    // build 메서드 내에서 호출될 생성자
//    // : Builder 패턴으로 만들어진 필드값들을 전달 받는 생성자
//    public LombokClass(Builder builder) {
//        this.title = builder.title;
//        this.author = builder.author;
//    }
}

public class H_Lombok {
    public static void main(String[] args) {
        LombokClass lombokClass1 = new LombokClass("Hello LSA", "LSA");
        // cf) final 변수값 - 재할당 불가!
        // lombokClass1.setTitle("승아야 안녕");
        lombokClass1.setAuthor("이승아");

        LombokClass lombokClass2 = new LombokClass("Merong LDK", "LDK");
        // lombokClass2.setTitle("이도경 메롱");
        lombokClass2.setAuthor("이도경");

        System.out.println(lombokClass1); // LombokClass(title=승아야 안녕, author=이승아)
        System.out.println(lombokClass2); // LombokClass(title=이도경 메롱, author=이도경)

        // 정적 내부 클래스: 클래스명.내부클래스()
        LombokClass lombokClass3 = LombokClass.builder()
                .title("이승아")
                .build();
        System.out.println(lombokClass3.getAuthor()); // 작가 미상

        // @NonNull 어노테이션 필드는 반드시 생성 시 값의 할당이 이루어져야 함!
//        LombokClass lombokClass4 = LombokClass.builder()
//                .author("루피")
//                .build();
//        System.out.println(lombokClass4.getTitle()); // Error
//        System.out.println(lombokClass4.getAuthor()); // 루피
    }
}