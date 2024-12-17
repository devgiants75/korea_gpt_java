package phr_solution.service;

import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.entity.Patient;

import java.util.List;

public interface PatientServiceInterface {
    void registerPatient(PatientRequestDto requestDto);
    List<PatientResponseDto> listAllPatients();
    PatientResponseDto getPatientById(Long id);
    void updatePatient(Long id, PatientRequestDto requestDto);
    void deletePatient(Long id);
}
