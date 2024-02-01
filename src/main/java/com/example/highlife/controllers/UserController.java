package com.example.highlife.controllers;

import com.example.highlife.models.Reservation;
import com.example.highlife.models.User;
import com.example.highlife.models.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    @GetMapping
    public String userIndex(Model model) {
        return "user/user_index";
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User currentUser = userDetails.getUser();
        Reservation reservation = new Reservation();
        reservation.setKorisnik(currentUser);
        model.addAttribute(reservation);
        return "user/dashboard";
    }

}
