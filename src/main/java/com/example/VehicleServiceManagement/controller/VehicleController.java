package com.example.VehicleServiceManagement.controller;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.model.Vehicle;
import com.example.VehicleServiceManagement.service.UserService;
import com.example.VehicleServiceManagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserService userService;

    // View all vehicles owned by logged-in user
    @GetMapping("/vehicles")
    public String viewMyVehicles(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Vehicle> vehicles = vehicleService.getVehiclesByOwner(user);
        model.addAttribute("vehicles", vehicles);
        return "vehicle-list";
    }

    // View vehicle details with access check
    @GetMapping("/vehicles/view/{id}")
    public String viewVehicleDetails(@PathVariable Long id, Model model, Principal principal) {
        Vehicle vehicle = vehicleService.findById(id);
        User loggedInUser = userService.findByUsername(principal.getName());

        if (!loggedInUser.getRole().equals("ROLE_ADMIN") &&
                !vehicle.getOwner().getId().equals(loggedInUser.getId())) {
            return "access-denied";
        }

        model.addAttribute("vehicle", vehicle);
        return "vehicle-details";
    }

    // ✅ Show form to add new vehicle
    @GetMapping("/vehicles/new")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public String showAddVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle-form";
    }

    // ✅ Handle form submission to save vehicle
    @PostMapping("/vehicles/save")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public String saveVehicle(@ModelAttribute Vehicle vehicle, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        vehicle.setOwner(user);
        Vehicle savedVehicle = vehicleService.save(vehicle); // Capture saved vehicle with ID

        return "redirect:/vehicles/" + savedVehicle.getId() + "/requests/new"; // Redirect to request form
    }
}
