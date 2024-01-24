package com.example.highlife.controllers;

import com.example.highlife.models.User;
import com.example.highlife.repositories.UserRepository;
import com.example.highlife.models.Role;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/auth/register")
    public String add (Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "admin/register";
    }

    @PostMapping("/auth/register")
    public String newUser (@Valid User user, BindingResult result, Model model){
        boolean errors = result.hasErrors();
        if (errors){
            model.addAttribute("user", user);
            return "admin/register";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passwordEncoded = encoder.encode(user.getLozinka());
            user.setLozinka(passwordEncoded);
            user.setPotvrdaLozinke(passwordEncoded);
            user.getRoles().add(Role.USER);
            userRepo.save(user);
            return "redirect:/auth/login";
        }
    }

    @GetMapping("/auth/login")
    public String login (Model model){
        model.addAttribute("user", new User());
        return "admin/login";
    }


}