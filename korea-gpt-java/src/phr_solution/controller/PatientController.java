package phr_solution.controller;

import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.entity.Patient;
import phr_solution.service.PatientService;

import java.util.List;

public class PatientController {
    private PatientService service;

    public PatientController() {
        service = new PatientService();
    }

    // 환자 정보 등록
    public void registerPatient(PatientRequestDto requestDto) {
        service.registerPatient(requestDto);
    }

    // 전체 환자 조회
    public List<PatientResponseDto> getAllPatients() {
        List<PatientResponseDto> patients = service.listAllPatients();
        return patients;
    }

    // 단건 환자 조회
    public PatientResponseDto getPatientById(long id) {
        PatientResponseDto patient = service.getPatientById(id);
        return patient;
    }

    // 환자 정보 수정
    public void updatePatient(long id, PatientRequestDto requestDto) {
        service.updatePatient(id, requestDto);
    }

    // 환자 정보 삭제
    public void deletePatient(long id) {
        service.deletePatient(id);
    }
}
