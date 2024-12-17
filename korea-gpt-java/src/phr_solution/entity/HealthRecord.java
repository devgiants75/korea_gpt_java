package phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthRecord {
    private Long id; // 건강 기록의 고유 번호
    private Long patientId; // 해당 기록의 환자 고유 번호
    private String dateOfVisit; // 방문 날짜
    private String diagnosis; // 진단
    private String treatment; // 처방
}
