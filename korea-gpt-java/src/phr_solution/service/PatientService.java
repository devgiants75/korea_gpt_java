package phr_solution.service;

import phr_solution.controller.PatientController;
import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.entity.Patient;
import phr_solution.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PatientService implements PatientServiceInterface {
    private PatientRepository repository;
    private static long currentId = 1; // ID 관리 변수

    public PatientService() {
        this.repository = PatientRepository.getInstance();
    }

    // ID 생성 로직
    // synchronized: 동기화를 위해 사용
    // - 여러 스레드가 동시에 generateId() 메서드를 호출하는 것을 방지
    // - 한 스레드가 메서드를 실행하는 동안 다른 스레드는 대기 상태에 놓임
    private synchronized Long generateId() {
        return currentId++;
    }

    @Override
    public void registerPatient(PatientRequestDto requestDto) {
        Patient newPatient = new Patient(
                generateId(),
                requestDto.getName(),
                requestDto.getAge(),
                requestDto.getGender()
        );

        repository.save(newPatient);
    }

    @Override
    public List<PatientResponseDto> listAllPatients() {
        List<Patient> patients = repository.findAll();
        List<PatientResponseDto> responseDtos = patients.stream()
                .map(patient -> new PatientResponseDto(patient.getName(), patient.getGender()))
                .collect(Collectors.toList());

        return responseDtos;
    }

    @Override
    public PatientResponseDto getPatientById(Long id) {
        PatientResponseDto responseDto = null;
        try {

            Patient patient = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 찾을 수 없습니다:" + id));

            responseDto = new PatientResponseDto(patient.getName(), patient.getGender());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public void updatePatient(Long id, PatientRequestDto requestDto) {
        try {
            Patient patient = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 찾을 수 없습니다:" + id));

            patient.setName(requestDto.getName());
            patient.setAge(requestDto.getAge());
            patient.setGender(requestDto.getGender());

            repository.save(patient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletePatient(Long id) {
        try {
            Patient patient = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 환자를 찾을 수 없습니다:" + id));

            repository.delete(patient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
