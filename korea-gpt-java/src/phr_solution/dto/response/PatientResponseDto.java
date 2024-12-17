package phr_solution.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientResponseDto {
    private String name;
    private String gender;
}
