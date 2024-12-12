package chapter14;

// === 직원 관리 시스템 === //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 2. 직원 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private double salary;
}

public class I_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이승아", 5000),
                new Employee("HR", "조승범", 7000),
                new Employee("IT", "김준일", 6500),
                new Employee("Finance", "전예찬", 4000),
                new Employee("HR", "윤대휘", 6300)
        );

        // 1. 급여가 6000 이상인 직원 필터링
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() >= 6000)
                .collect(Collectors.toList());

        // 2. IT 부서 직원의 이름만 추출
        List<String> itEmployeeNames = employees.stream()
                .filter(employee -> "IT".equals(employee.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());

        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        List<Employee> employeesWithJo = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());
    }
}
