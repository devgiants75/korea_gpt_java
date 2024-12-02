package chapter06;

import javax.swing.text.html.parser.TagElement;
import java.util.ArrayList;

// Student 클래스 설계
class Student {
    // == 필드 ==
    int studentId; // 학생 ID
    String name; // 학생 이름
    int age; // 학생 나이
    String major; // 전공
    double gpa; // 평균 학점

    // == 메서드 ==
    void printStudentInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Age: " + age +
                ", Major: " + major + ", GPA: " + gpa);
    }

    // 평점 업데이트
    void updateGpa(double newGpa) {
        this.gpa = newGpa;
    }

    // == 생성자 ==
    Student() {
       this.studentId = 0;
       this.name = "Unknown";
       this.age = 0;
       this.major = "Undeclared";
       this.gpa = 0.0;
    }

    Student(int studentId, String name, int age, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
}


// 학생 관리 시스템
// - 클래스로 구성
//      : Java 프로그램은 클래스 단위로 구성
//      +) 클래스명은 파일 이름과 동일해야 함. (대소문자까지 동일)
// - 메인 메서드(main)를 포함하여 프로그램의 시작 지점을 제공
public class StudentManagementApp {
    // main 메서드
    // : Java 프로그램이 실행될 때 가장 먼저 호출되는 메서드

    // - public: JVM이 외부에서 해당 메서드를 호출할 수 있도록 설정
    //          +) 프로그램 시작 시 JVM이 접근해야하기 때문에 반드시 public!

    // - static: 정적 메서드, 메서드가 인스턴스 생성 없이 호출됨.
    //          +) JVM이 클래스의 객체를 생성하지 않고도 메서드를 직접 호출하기 위해 필요

    // - 'main': JVM이 프로그램 실행 시 가장 먼저 찾는 메서드 이름 - 반드시 main이어야 함.
    //          +) 대소문자를 구분하기 때문에 'main'로 작성

    // - String[] args: 명령행에서 전달된 값을 받을 수 있는 매개변수
    //          +) 명령행에서 전달되는 모든 인자는 문자열 형태로 전달

    // = main 메서드 역할 =
    // : 프로그램의 진입점으로 작동
    // : 반드시 public static void main(String[] args) 형식을 유지해야 실행 가능
    // : 클래스에 메인 메서드가 없을 경우 JVM은 실행 시 오류를 발생.

    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        // 학생 추가
        addStudent(1, "이승아", 28, "GPT반", 4.0);
        addStudent(2, "이도경", 30, "IoT반", 3.8);
        addStudent(3, "이지희", 19, "GPT반", 4.3);
        addStudent(4, "이지훈", 16, "빅데이터반", 4.1);

        printAllStudents();
    }

    // cf) static 메서드인 이유!
    //      : static 메서드는 인스턴스 없이 클래스 자체에서 직접 호출!
    //      : main 메서드 내부에서 다른 메서드를 호출하려면 해당 메서드는 static이어야 함!

    // 학생 등록
    static void addStudent(int id, String name, int age, String major, double gpa) {
        Student student = new Student(id, name, age, major, gpa);
        studentList.add(student);
        System.out.println("학생이 등록되었습니다.");
    }

    // 모든 학생 출력
    static void printAllStudents() {
        System.out.println("=== 전체 학생 목록 ===");
        for (Student student : studentList) {
            student.printStudentInfo();
        }
    }
}
