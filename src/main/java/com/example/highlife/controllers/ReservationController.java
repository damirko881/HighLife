package com.example.highlife.controllers;

import com.example.highlife.models.Reservation;
import com.example.highlife.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return ResponseEntity.ok("Rezervacija uspješno stvorena i spremljena.");
    }
}
