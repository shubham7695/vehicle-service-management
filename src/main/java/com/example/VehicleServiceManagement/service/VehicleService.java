package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.Vehicle;
import com.example.VehicleServiceManagement.model.User;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    List<Vehicle> findByOwner(User user);
    Vehicle findById(Long id);
    Vehicle save(Vehicle vehicle);
    List<Vehicle> getVehiclesByOwner(User owner);
    void deleteById(Long id);
}
