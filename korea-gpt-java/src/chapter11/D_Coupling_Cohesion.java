package chapter11;

// === 결합도 & 응집도 === //

// cf) 모듈
//      : 소프트웨어를 각 기능별로 나눈 소스 단위
// +) 모듈화: 하나의 큰 소프트웨어를 분리시키는 과정
// >> "좋은 소프트웨어 일수록 모듈의 독립성이 높다"
// >> 모듈의 독립성을 결합도(Coupling)와 응집도(Cohesion)의 기준 단계로 측정

// 1. 결합도 (낮은 결합도)
// : 두 개의 클래스나 모듈이 얼마나 강하게 연결되어 있는지를 나타냄
// : 모듈과 모듈 간의 의존 정도

// - 낮은 결합도: 두 모듈이 서로 독립적으로 동작
// - 높은 결합도: 두 모듈이 서로 얽혀있는 관계

// >> 낮은 결합도
//      : 프로그램을 유지보수하기 쉽게 만들고,
//          새로운 기능을 추가하거나 기존 코드를 수정할 때 오류 발생 가능성을 낮춤

// 2. 응집도 (높은 응집도)
// : 하나의 클래스나 모듈 안에서 관련된 작업들끼리 얼마나 잘 모여 있는지를 나타냄
// : 한 모듈 내의 구성요소들 간의 연관 정도

// - 높은 응집도: 하나의 클래스가 관련된 일들만 하고, 해당 일이 잘 명시
// - 낮은 응집도: 하나의 클래스가 너무 많은 일을 하거나, 관련 없는 일을 하는 것

// >> 높은 응집도
//      : 프로그램에 대한 이해, 유지보수를 용이

// == 결합도와 응집도의 관계 ==
// 낮은 결합도 + 높은 응집도
// : 각 클래스나 모듈이 독립적으로 동작하면서도, 본인의 역할에 충실
// >> 유지보수가 쉽고, 확장성이 좋음

// == 낮은 결합도와 높은 응집도 구현 == //
// : 클래스 간의 의존성을 줄이고, 변경에 강한 구조를 작성

// 1. 낮은 결합도
// 1-1) 인터페이스와 다형성 활용
//      : 구현 클래스에 의존하지 않고, 인터페이스를 통해 서로 의존하게 구현 (DIP)
//      >> 구현이 변경되거나 확장되어도 인터페이스에만 맞추면 동작

// 인터페이스 정의
interface Payment {
    void processPayment();
}

// 구현 클래스
class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("신용카드로 결제합니다.");
    }
}

class OrderClass {
    // 1-2) 의존성 주입 (Dependency Injection)
    // : 클래스가 직접 객체를 생성하지 않고, 외부에서 객체를 주입받도록 설계
    // - 객체 간의 강한 결합을 줄이고, 변경에 유연
    CreditCardPayment creditCardPayment = new CreditCardPayment();

    private Payment payment;

    public OrderClass(Payment payment) {
        this.payment = payment;
    }

    void checkout() {
        payment.processPayment();
        // creditCardPayment.processPayment();
    }
}

// 2. 높은 응집도
// 2-1) 단일 책임 원칙 (SRP)
// : 클래스는 단 하나의 책임만 가져야 함.
class User {
    // 2-2) 캡슐화
    //      : 필드를 private 설정, getter와 setter를 통해 접근
    //      : 클래스의 내부 동작을 숨기고, 외부와의 상호작용을 최소화
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getName() {
        return name;
    }
}

class UserRepository {
    public void save(User user) {
        // == 저장 로직 구현 ==
        System.out.println("사용자 정보가 데이터베이스에 저장되었습니다.");
    }
}

class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    // 회원 가입 로직
    public void registerUser(User user) {
        // 회원가입에 대한 추가 로직
        if (user.getName().isEmpty()) {
            System.out.println("이름은 필수사항입니다.");
            return;
        }
        userRepository.save(user);
    }
}


public class D_Coupling_Cohesion {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment(); // 의존성 주입
        OrderClass order = new OrderClass(payment);
        order.checkout(); // 신용카드로 결제합니다.
    }
}

// 낮은 결합도: 인터페이스와 다형성, 의존성 주입 등
// 높은 응집도: 단일 책임 원칙 준수, 캡슐화, 모듈화(메서드 분리) 등