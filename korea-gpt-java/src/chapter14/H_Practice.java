package chapter14;

// == 컬렉션 프레임워크 & 스트림 API & 람다 표현식 & 메서드 참조 == //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. 학생 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;
}

public class H_Practice {
    public static void main(String[] args) {
        // 1. 학생 목록 필터링 & 정렬
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("이승아", 29, 4.3),
                new StudentClass("이도경", 33, 4.1),
                new StudentClass("이지훈", 20, 3.8),
                new StudentClass("이지희", 25, 3.5)
        );

        // 1-1. 학점이 4.0 이상인 학생 필터링
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());

        System.out.println("학점이 3.0 이상인 학생: ");
        filteredStudents.forEach(System.out::println);
//        학점이 3.0 이상인 학생:
//        StudentClass(name=이승아, age=29, grade=4.3)
//        StudentClass(name=이도경, age=33, grade=4.1)

        // 1-2. 학생 이름 목록만 추출
        List<String> studentNames = studentClasses.stream()
//                .map(studentClass -> studentClass.getName())
                .map(StudentClass::getName)
                .collect(Collectors.toList());

        System.out.println("학생 이름 목록: ");
        System.out.println(studentNames); // [이승아, 이도경, 이지훈, 이지희]

        // 1-3. 학생들을 점수순으로 정렬
        List<StudentClass> sortedStudents = studentClasses.stream()
                .sorted(Comparator.comparingDouble(StudentClass::getGrade))
                .collect(Collectors.toList());

        System.out.println("점수 순으로 정렬된 학생들: ");
        sortedStudents.forEach(System.out::println);
//        StudentClass(name=이지희, age=25, grade=3.5)
//        StudentClass(name=이지훈, age=20, grade=3.8)
//        StudentClass(name=이도경, age=33, grade=4.1)
//        StudentClass(name=이승아, age=29, grade=4.3)

        // 1-4. 학생들 중 '지' 단어가 이름에 포함된 학생 필터링
        List<StudentClass> studentsWithJi = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("지"))
                .collect(Collectors.toList());

        System.out.println("이름에 '지'가 포함된 학생: ");
        studentsWithJi.forEach(System.out::println);
//        StudentClass(name=이지훈, age=20, grade=3.8)
//        StudentClass(name=이지희, age=25, grade=3.5)
    }
}
