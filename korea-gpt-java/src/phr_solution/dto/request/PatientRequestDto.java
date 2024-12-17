package phr_solution.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientRequestDto {
    private String name;
    private int age;
    private String gender;
}
