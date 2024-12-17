package phr_solution.controller;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.RecordResponseDto;
import phr_solution.service.RecordService;

import java.util.List;

public class RecordController {
    private final RecordService service;

    public RecordController() {
        this.service = new RecordService();
    }

    // 건강 기록 추가
    public void createRecord(RecordRequestDto requestDto) {
        service.createRecord(requestDto);
    }

    // 건강 기록 전체 조회
    public List<RecordResponseDto> getAllRecords() {
        return service.getAllRecords();
    }

    // 건강 기록 필터링 조회
    public List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosisFilter) {
        return service.filterRecordsByDiagnosis(diagnosisFilter);
    }

    // 건강 기록 삭제
    public void deleteRecord(long id) {
        service.deleteRecord(id);
    }
}
