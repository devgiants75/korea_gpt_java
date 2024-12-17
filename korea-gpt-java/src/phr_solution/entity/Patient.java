package phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private Long id; // 환자의 고유 번호
    private String name;
    private int age;
    private String gender;
}
