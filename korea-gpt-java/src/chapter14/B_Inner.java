package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 학교 클래스
@AllArgsConstructor
@Getter
class School {
    private String schoolName;

    // 내부 클래스
    @AllArgsConstructor
    class Student {
        private String studentName;
        private int studentId;

        public void displayInfo() {
            System.out.println("학교명 " + schoolName + ", 학생 이름: " + studentName + ", 학생 ID: " + studentId);
        }
    }

    // 내부 클래스 - 교장 선생님 (싱글톤 패턴)
    static class Principal {
        private static Principal instance;

        private Principal() {}

        public static Principal getInstance() {
            if (instance == null) {
                instance = new Principal();
            }
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈화말씀: 공부 열심히하고 밥 잘먹고 일찍 자고 일찍 일어나세요");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {

    }
}
