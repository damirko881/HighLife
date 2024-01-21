package com.example.highlife.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/teacher")
@PreAuthorize("hasAuthority('TEACHER')")
public class UserController {
    @GetMapping
    public String teacherDashboard(Model model) {
        return "user/dashboard";
    }
}
