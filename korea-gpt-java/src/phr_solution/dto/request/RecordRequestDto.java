package phr_solution.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordRequestDto {
    private Long patientId; // 해당 기록의 환자 고유 번호
    private String dateOfVisit; // 방문 날짜
    private String diagnosis; // 진단
    private String treatment; // 처방
}
