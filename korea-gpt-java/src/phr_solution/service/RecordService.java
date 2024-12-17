package phr_solution.service;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.RecordResponseDto;
import phr_solution.entity.HealthRecord;
import phr_solution.entity.Patient;
import phr_solution.repository.PatientRepository;
import phr_solution.repository.RecordRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecordService implements RecordServiceInterface {
    private final RecordRepository recordRepository;
    private final PatientRepository patientRepository;

    private static long currentId = 1;

    public RecordService() {
        this.recordRepository = RecordRepository.getInstance();
        this.patientRepository = PatientRepository.getInstance();
    }

    private synchronized Long generatedRecordId() {
        return currentId++;
    }

    // 환자 ID 유효성 검증
    private void validatePatientId(Long patientId) {
        // 환자 존재 여부 확인
        Optional<Patient> foundPatient = patientRepository.findById(patientId);

        if (!foundPatient.isPresent()) {
           throw new IllegalArgumentException("해당 ID의 환자를 찾을 수 없습니다. ID: " + patientId);
        }
    }

    @Override
    public void createRecord(RecordRequestDto requestDto) {
        try {
            validatePatientId(requestDto.getPatientId());

            HealthRecord record = new HealthRecord(
                    generatedRecordId(),
                    requestDto.getPatientId(),
                    requestDto.getDateOfVisit(),
                    requestDto.getDiagnosis(),
                    requestDto.getTreatment()
            );

            recordRepository.save(record);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RecordResponseDto> getAllRecords() {
        List<RecordResponseDto> responseDtos = null;
        try {
            List<HealthRecord> records = recordRepository.findAll();

            responseDtos = records.stream()
                    .map(record -> new RecordResponseDto(
                            record.getId(),
                            record.getPatientId(),
                            record.getDateOfVisit(),
                            record.getDiagnosis(),
                            record.getTreatment(),
                            new Date()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return responseDtos;
    }

    @Override
    public List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosis) {
        List<RecordResponseDto> responseDtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();

            responseDtos = records.stream()
                    .filter(record -> record.getDiagnosis().contains(diagnosis))
                    .map(filteredRecord -> new RecordResponseDto(
                            filteredRecord.getId(),
                            filteredRecord.getPatientId(),
                            filteredRecord.getDateOfVisit(),
                            filteredRecord.getDiagnosis(),
                            filteredRecord.getTreatment(),
                            new Date()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return responseDtos;
    }

    @Override
    public void deleteRecord(Long id) {
        try {
            HealthRecord healthRecord = recordRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID의 건강 기록은 존재하지 않습니다. ID: " + id));

            recordRepository.delete(healthRecord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
