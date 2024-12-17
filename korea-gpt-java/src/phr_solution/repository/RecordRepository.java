package phr_solution.repository;

import phr_solution.entity.HealthRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecordRepository {
    private List<HealthRecord> records = new ArrayList<>();
    private static RecordRepository instance = new RecordRepository();

    private RecordRepository() {}

    public static RecordRepository getInstance() {
        return instance;
    }

    public void save(HealthRecord record) {
        records.add(record);
    }

    public List<HealthRecord> findAll() {
        return new ArrayList<>(records);
    }

    public Optional<HealthRecord> findById(Long id) {
        return records.stream()
                .filter(record -> record.getId().equals(id))
                .findFirst();
    }

    public void delete(HealthRecord healthRecord) {
        records.remove(healthRecord);
    }
}
