package chapter07;

// === 다형성 === //
// : 많은 형태를 가질 수 있는 특성
// >> 하나의 객체가 여러 타입의 인스턴스(객체)로 취급될 수 있는 특성
// >> 상속 + 메서드 오버라이딩 + 클래스 타입 변환

// cf) instanceof 연산자
// : 참조변수값 instanceof 타입(클래스명)
// >> 해당 객체가 특정 클래스의 인스턴스인지
//      또는 그 클래스를 상속받은 자식 클래스의 인스턴스인지 확인
// >> boolean 값으로 반환

// Vehicle: 운송 수단, 탈 것
class Vehicle {
    void display() {
        System.out.println("운송수단입니다.");
    }
}

class Bus extends Vehicle {
    @Override
    void display() {
        System.out.println("버스를 타고 갑니다.");
    }
}

class Subway extends Vehicle {
    @Override
    void display() {
        System.out.println("지하철을 타고 갑니다.");
    }
}

public class F_Polymorphism {
    public static void main(String[] args) {
        // 다형성 적용
        // : 부모 클래스 타입의 참조 변수로 자식 클래스 객체를 참조
        Vehicle myVehicle = new Vehicle();
        Vehicle myBus = new Bus();
        Vehicle mySubway = new Subway();

        if (myBus instanceof Vehicle) {
            // myBus 객체가 Vehicle의 인스턴스 || Vehicle을 상속받은 인스턴스의 경우
            myBus.display();
        }

        if (myVehicle instanceof Bus) {
            System.out.println("운송수단은 버스입니다.");
        } else {
            System.out.println("운송수단은 버스가 아닙니다.");
        }

        // instanceof 연산자 계산식에서 true 값일 경우
        // : 해당 클래스 타입으로 형 변환이 가능!
    }
}
