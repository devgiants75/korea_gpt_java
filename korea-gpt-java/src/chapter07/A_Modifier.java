package chapter07;

// == 자바 패키지 또는 클래스 파일 간의 코드 연결 == //
// : import 문을 사용

// 1) 같은 패키지 내: import 클래스파일명;
// 2) 다른 패키지 내: import 패키지명.클래스파일명;
import otherPackage.OtherClass;
import otherPackage.PublicClass;

// === 접근 제어자(제한자) === //
// : 클래스, 메서드, 변수의 접근 범위를 제어하여 외부로부터
//      데이터를 보호하고 객체 간의 의존성을 최소화하는 역할
// - 캡슐화를 구현, 코드의 보안성을 향상

// 1. 접근 제어자 종류
// : private, default, protected, public
// >> 접근 제어자가 지정되지 않은 경우 default(기본값)으로 지정

// +) 클래스 자체에 접근 제한자 사용 X
//      : 중첩 클래스의 경우 사용 가능

// public class Modifier {} - Error: 접근 제어자 사용 X

// 2. 접근 제어자 범위
// public > protected > (default) > private

// 1) private
// : 같은 클래스 내에서만 접근 가능
class PrivateClass {
    private int myField;
    private void myMethod() {}
}

// 2) (default)
// : 같은 패키지 내라면 접근 가능
// : 패키지 외부에서는 접근 불가능
class DefaultClass {
    int myField;
    void myMethod() {}
}

// 3) protected
// : 동일한 패키지 내의 모든 클래스 내에서 접근 가능
// : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근 가능
class ProtectedClass extends OtherClass {

    // 같은 패키지 내: 모든 클래스에서 접근 가능
    protected int myField;
    protected void myMethod() {}

    // 다른 패키지의 경우 상속받은 하위 클래스에서만 접근 가능
    ProtectedClass() {
        System.out.println(otherField); // 상속받은 부모 클래스의 필드
        otherMethod(); // 상속받은 부모 클래스의 메서드
    }
}

// 4) public
// : 어떤 클래스든 어떤 패키지 내에 있든 접근 가능

class NotProtectedClass {
    NotProtectedClass() {
        // System.out.println(OtherClass.otherField);
        // >> 'otherField' has protected access in 'otherPackage. OtherClass'

        // OtherClass.otherMethod();
        // >> 'otherMethod()' has protected access in 'otherPackage. OtherClass'
    }
}

public class A_Modifier {
    public class Modifier {} // 접근 제어자 사용 O (중첩 클래스)

    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
        // privateClass.myField;
        // privateClass.myMethod();
        // >> private 설정 된 속성과 메서드는
        //      해당 클래스 내부에서만 읽을 수 있음

        DefaultClass defaultClass = new DefaultClass();
        defaultClass.myField = 10;
        defaultClass.myMethod();

        ProtectedClass protectedClass = new ProtectedClass();
        protectedClass.myField = 20;
        protectedClass.myMethod();

        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();
    }
}
