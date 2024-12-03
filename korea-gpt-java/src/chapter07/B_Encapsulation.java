package chapter07;

// === 캡슐화(Encapsulation) === //
// : 객체 지향 프로그래밍에서 데이터와 해당 데이터를 처리하는 함수를
//      하나로 묶는 것을 의미
// - 객체 내부의 구현을 숨기고 외부에서는 제공된 메서드를 통해서만 접근할 수 있게 설정
// >> 데이터 보호, 유지보수성 향상, 사용자 편의성 증대

// - 데이터 보호와 유지보수성 향상을 목적으로 데이터 필드(속성)를 private으로 선언
//      & 데이터에 접근하거나 수정할 때는 getter와 setter 메서드를 사용하게 하는 체계

// == getter & setter 메서드 ==
// : 캡슐화 된 데이터에 안전하게 접근하고 수정할 수 있도록 하는 기능

// - getter: 객체의 특정 필드 값을 읽는 메서드
//      get<필드명>();
//      EX) getName, getAge
// - setter: 객체의 특정 필드 값을 설정하는 메서드
//      set<필드명>();
//      EX) setName, setAge

// == 예시) 학생 정보 관리 클래스 ==
class Student {
    private String name;
    private int age;
    private int score;

    // getter & setter 메서드
    // : 캡슐화 되어 있는 데이터에 접근

    // cf) setter의 경우 입력 값의 유효성을 검사하여 데이터의 일관성을 유지할 수 있음

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("유효하지 않은 나이입니다.");
        } else {
            this.age = age;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("유효하지 않은 점수입니다.");
        }
    }
}

public class B_Encapsulation {
    public static void main(String[] args) {
        Student student = new Student();
        // student.name = "이승아"; - Error

        student.setName("이승아");
        student.setAge(50);
        student.setScore(90);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getScore());

        student.setAge(-10); // 유효하지 않은 나이입니다.
        student.setScore(101); // 유효하지 않은 점수입니다.
    }
}
