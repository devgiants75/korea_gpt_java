package chapter17.service;

import chapter17.entity.Reservation;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void createReservation(String reservationId, String userId, String reservationTime) {

    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return List.of();
    }

    @Override
    public void cancelReservation(String reservationId) {

    }
}
