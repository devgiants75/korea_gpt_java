package chapter04;

// === 객체 지향 프로그래밍 - 클래스와 객체 === //

// 1. 클래스(Class) 정의
// : 객체를 만들기 위한 템플릿
// : 객체의 상태(속성)와 행동(메서드)을 정의
// - 데이터와 기능의 구조를 정의하는 하나의 개념적인 틀
// +) 실제 데이터 X (메모리에 올라가지 X) - 구조 정의에 불과

// class 키워드를 사용하여 정의
// : 클래스명은 UpperCamelCase 사용
class 클래스명 {
}

// 2. 객체(Object) 정의
// : 클래스에 정의된 속성과 메서드를 가지고 있는 '실체'
// : 클래스를 기반으로 생성
// - 클래스의 '인스턴스'라고 불림, 메모리에 할당
// > 각 객체는 독립적인 상태와 행동을 가짐
// > 다른 객체와 상호작용 가능

// cf) 인스턴스화
//      : 클래스라는 템플릿을 기반으로 객체를 만드는 과정
//      : 이때 만들어진 객체를 인스턴스(Instance)라고 부름

public class Object02 {
    public static void main(String[] args) {
        // 클래스 선언 방법
        // [접근제한자] class ClassName {
            // 클래스가 가지는 속성과 행동을 정의
            // - 속성: 변수
            // - 행동: 함수(메서드, method)
        // }

        // == 접근 제한자(제어자) ==
        // : 생략 가능
        // - 클래스의 가시성을 정의 (접근에 대한 권한을 부여)
        // EX) public, private, protected, default

        // public: 모든 클래스에서 접근 가능
        // private: 해당 클래스 내부에서만 접근 가능
        // protected: 같은 패키지(폴더) 내부 또는 상속 관계에 있는 클래스에서만 접근 가능
        // (default): 같은 패키지 내에서만 접근 가능 (기본값 - 생략 시 지정)

        class Car {
            // 속성(필드) - 변수 선언 방식
            int maxSpeed;
            double weight;
            boolean isElectric;
        }

        class Book {
            String title;
            String author;
            int[] pageNumber;
        }

        class Person {
            String name;
            int age;
            double height;
            boolean isStudent;
        }
    }
}
