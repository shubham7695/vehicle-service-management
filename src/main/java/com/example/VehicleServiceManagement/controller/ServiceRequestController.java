package com.example.VehicleServiceManagement.controller;

import com.example.VehicleServiceManagement.model.*;
import com.example.VehicleServiceManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ServiceRequestController {

    @Autowired private VehicleService vehicleService;
    @Autowired private UserService userService;
    @Autowired private MechanicService mechanicService;
    @Autowired private ServiceRequestService serviceRequestService;

    // View service requests for a specific vehicle (Customer)
    @GetMapping("/vehicles/{vehicleId}/requests")
    public String viewVehicleRequests(@PathVariable Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.findById(vehicleId);
        List<ServiceRequest> requests = serviceRequestService.findByVehicle(vehicle);
        model.addAttribute("vehicleId", vehicleId);
        model.addAttribute("requests", requests);
        return "service-request-list";
    }

    // CUSTOMER: Show form to create service request for a vehicle
    @GetMapping("/vehicles/{vehicleId}/requests/new")
    public String showCreateRequestForm(@PathVariable Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.findById(vehicleId);
        ServiceRequest request = new ServiceRequest();
        request.setVehicle(vehicle);
        model.addAttribute("request", request);
        model.addAttribute("vehicleId", vehicleId);
        return "service-request-form";
    }

    // CUSTOMER: Handle new service request form submission
    @PostMapping("/vehicles/{vehicleId}/requests/new")
    public String createRequest(@PathVariable Long vehicleId, @ModelAttribute ServiceRequest request) {
        Vehicle vehicle = vehicleService.findById(vehicleId);
        request.setVehicle(vehicle);
        request.setStatus(ServiceRequest.Status.NEW);
        serviceRequestService.save(request);
        return "redirect:/vehicles";
    }

    // ADMIN: View all service requests
    @GetMapping("/admin/requests")
    public String manageAllRequests(Model model) {
        List<ServiceRequest> requests = serviceRequestService.getAll();
        model.addAttribute("requests", requests != null ? requests : List.of());
        return "service-request-list";
    }

    // ADMIN: Edit service request
    @GetMapping("/requests/edit/{id}")
    public String editRequest(@PathVariable Long id, Model model) {
        ServiceRequest request = serviceRequestService.findById(id);
        List<Mechanic> mechanics = mechanicService.findAll();
        model.addAttribute("request", request);
        model.addAttribute("mechanics", mechanics);
        return "service-request-edit-form";
    }

    @PostMapping("/requests/update/{id}")
    public String updateRequest(@PathVariable Long id,
                                @ModelAttribute("request") ServiceRequest request,
                                @RequestParam("mechanicId") Long mechanicId) {
        ServiceRequest existing = serviceRequestService.findById(id);
        existing.setDescription(request.getDescription());
        existing.setStatus(request.getStatus());
        Mechanic mechanic = mechanicService.findById(mechanicId);
        existing.setMechanic(mechanic);
        serviceRequestService.save(existing);
        return "redirect:/admin/requests";
    }

    // ADMIN: Add new request (optional future use)
    @GetMapping("/admin/requests/new")
    public String showAdminCreateRequestForm(Model model) {
        model.addAttribute("request", new ServiceRequest());
        return "service-request-form";
    }
}
