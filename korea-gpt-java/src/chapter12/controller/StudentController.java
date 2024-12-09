package chapter12.controller;

import chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String id) {
//        학생 추가 시
//        입력한 id의 학생이 존재하는 경우
//        메시지 출력 + 추가 X
        Student student = findStudentById(id);

        if (student != null) {
            // 입력받은 id의 학생이 있는 경우
            System.out.println("해당 id의 학생이 이미 존재합니다.");
            return;
        }

        students.add(new Student(name, age, id));
    }

    // 전체 조회
    public List<Student> getAllStudents() {
        return students;
    }

    // 단건 조회
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student; // 해당 학번의 학생을 반환
            }
        }

        return null; // 학번에 해당하는 학생이 없을 경우 null 반환
    }

    public boolean updateStudent(String id, String newName, int newAge) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }

        return false;
    }

    public boolean removeStudent(String id) {
//        for (Student student : students) {
//            if (student.getStudentId().equals(id)) {
//                students.remove(student);
//                return true;
//            }
//        }
//        return false;

        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
