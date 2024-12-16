package chapter17.service;

import chapter17.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void createReservation(String reservationId, String userId);
    List<Reservation> getReservationsByUserId(String userId);
    void cancelReservation(String reservationId);
}
