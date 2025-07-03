package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.ServiceRequest;
import com.example.VehicleServiceManagement.model.Vehicle;

import java.util.List;

public interface ServiceRequestService {
    List<ServiceRequest> getAll();
    List<ServiceRequest> findByVehicle(Vehicle vehicle);
    ServiceRequest findById(Long id);
    ServiceRequest save(ServiceRequest request);
    void deleteById(Long id);
}
