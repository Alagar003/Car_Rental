package org.example.Services;


import org.example.Model.Reservation;
import org.example.Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;

public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Add a reservation
    public void addReservation(Reservation reservation) {
        reservationRepository.getReservations().add(reservation);
    }

    // Check if the car is available for the given dates
    public boolean isCarAvailable(String licensePlate, Date startDate, Date endDate) {
        for (Reservation reservation : reservationRepository.getReservations()) {
            if (reservation.getLicensePlate().equals(licensePlate) &&
                    !(endDate.before(reservation.getStartDate()) || startDate.after(reservation.getEndDate()))) {
                return false; // Car is not available
            }
        }
        return true; // Car is available
    }
}
