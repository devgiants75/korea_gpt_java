package chapter17.repository;

import chapter17.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    // 예약 등록 (Reservation 객체)
    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    // 예약 확인 (userId로 예약 조회)
    public List<Reservation> findByUserId(String userId) {
        return reservations.stream()
                // filter() 메서드
                // : 조건에 일치하는 Stream 객체만 새로운 Stream으로 반환
                .filter(res -> res.getUserId().equals(userId) && res.isActive())
                .collect(Collectors.toList());
    }

    // 예약 취소 (reservationId로 예약 조회)
    public Optional<Reservation> findById(String reservationId) {
        return reservations.stream()
                .filter(res -> res.getReservationId().equals(reservationId)).findFirst();
    }
}