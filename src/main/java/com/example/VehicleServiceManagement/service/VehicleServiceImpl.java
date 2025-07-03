package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.model.Vehicle;
import com.example.VehicleServiceManagement.repository.VehicleRepository;
import com.example.VehicleServiceManagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
    @Override
    public List<Vehicle> getVehiclesByOwner(User user) {
        return vehicleRepository.findByOwner(user);
    }

    @Override
    public List<Vehicle> findByOwner(User owner) {
        return vehicleRepository.findByOwner(owner);
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }
}
