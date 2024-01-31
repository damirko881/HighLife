package com.example.highlife.controllers;

import com.example.highlife.models.Reservation;
import com.example.highlife.models.User;
import com.example.highlife.repositories.ReservationRepository;
import com.example.highlife.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/reservations/create")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation,
                                                    @AuthenticationPrincipal User currentUser) {

        // Provjeri je li datum prisutan
        Date datumRezervacije = reservation.getDatum();
        if (datumRezervacije == null) {
            return ResponseEntity.badRequest().body("Datum rezervacije je obavezan.");
        }

        // Provjeri je li korisnik već rezervirao podij
        boolean userAlreadyReserved = reservationRepository.existsByKorisnik(currentUser);
        if (userAlreadyReserved) {
            return ResponseEntity.badRequest().body("Već ste rezervirali podij. Možete rezervirati samo jedan podij.");
        }

        // Postavite korisnika i spremite rezervaciju
        reservation.setKorisnik(currentUser);
        reservationRepository.save(reservation);

        return ResponseEntity.ok("Rezervacija uspješno stvorena i spremljena.");
    }
}
