package com.example.highlife.controllers;

import com.example.highlife.models.Reservation;
import com.example.highlife.models.User;
import com.example.highlife.repositories.ReservationRepository;
import com.example.highlife.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/reservations/create")
    public String createReservation(@Valid Reservation reservation) {
        reservationRepository.save(reservation);
        return "redirect:/user/dashboard";
    }
}
