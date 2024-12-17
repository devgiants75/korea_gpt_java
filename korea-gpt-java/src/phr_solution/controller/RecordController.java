package phr_solution.controller;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.entity.HealthRecord;

import java.util.List;

public class RecordController {
    // 건강 기록 추가
    public void createRecord(RecordRequestDto requestDto) {
    }

    // 건강 기록 전체 조회
    public List<HealthRecord> getAllRecords() {
    }

    // 건강 기록 필터링 조회
    public List<HealthRecord> filterRecordsByDiagnosis(String diagnosisFilter) {
    }

    // 건강 기록 삭제
    public void deleteRecord(long id) {
    }
}
