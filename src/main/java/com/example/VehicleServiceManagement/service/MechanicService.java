package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.Mechanic;

import java.util.List;

public interface MechanicService {
    List<Mechanic> findAll();
    Mechanic findById(Long id);
    Mechanic save(Mechanic mechanic);
    void deleteById(Long id);
}
