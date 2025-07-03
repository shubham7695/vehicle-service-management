package com.example.VehicleServiceManagement.controller;

import com.example.VehicleServiceManagement.model.Mechanic;
import com.example.VehicleServiceManagement.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/mechanics")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @GetMapping
    public String listMechanics(Model model) {
        model.addAttribute("mechanics", mechanicService.findAll());
        return "mechanic-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("mechanic", new Mechanic());
        return "mechanic-form";
    }

    @PostMapping("/add")
    public String saveMechanic(@ModelAttribute Mechanic mechanic) {
        mechanicService.save(mechanic);
        return "redirect:/admin/mechanics";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Mechanic mechanic = mechanicService.findById(id);
        model.addAttribute("mechanic", mechanic);
        return "mechanic-form";
    }

    @PostMapping("/edit/{id}")
    public String updateMechanic(@PathVariable Long id, @ModelAttribute Mechanic mechanic) {
        mechanic.setId(id);
        mechanicService.save(mechanic);
        return "redirect:/admin/mechanics";
    }

    @GetMapping("/delete/{id}")
    public String deleteMechanic(@PathVariable Long id) {
        mechanicService.deleteById(id);
        return "redirect:/admin/mechanics";
    }
}
