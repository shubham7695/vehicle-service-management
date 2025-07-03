package com.example.VehicleServiceManagement.controller;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Show registration page
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle registration form submit
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "Username already exists");
            return "register";
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default role
        user.setRole("ROLE_CUSTOMER");

        userService.save(user);
        return "redirect:/login";
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
