package chapter04;

// === 클래스의 구조 === //
// : 필드(데이터를 표현하는 속성), 메서드(데이터의 동작), 생성자(데이터를 생성하는 역할)

class Car {
    // 클래스의 속성(필드)
    String model; // 모델
    int year; // 제조 연도

    // 클래스의 행동(메서드)
    // : 클래스 내부에서 정의된 함수, 객체의 행동을 표현
    // > 클래스의 속성(필드)을 사용하여 특정 작업을 수행하거나
    //      , 해당 값을 변경 또는 반환 가능

    /*
        반환타입 메서드명(매개변수...) {
            메서드의 동작을 정의
        }

        cf) void 반환타입
            : 해당 메서드(함수, 행동)의 반환하는 결과가 X
            : 반환(return)이 존재하지 않을 경우 메서드명 앞에 반드시 작성
    */
    void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }

    // 클래스의 생성자
    // : 클래스의 이름과 동일한 메서드
    // - 객체가 생성될 때 자동으로 호출
    // - 클래스 내부의 필드를 초기화할 때 주로 사용
    // +) 생성자는 반환타입을 가지지 X
    Car(String modelName, int year) {
        model = modelName;
        this.year = year;
    }
}

public class Object03 {
    public static void main(String[] args) {

    }
}
