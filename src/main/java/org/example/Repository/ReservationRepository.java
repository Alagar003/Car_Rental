package org.example.Repository;


import org.example.Model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private List<Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new ArrayList<>(); // Start with an empty list
    }

    // Method to add a reservation
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Method to retrieve all reservations
    public List<Reservation> getReservations() {
        return reservations;
    }
}
