package com.example.VehicleServiceManagement.repository;

import com.example.VehicleServiceManagement.model.ServiceRequest;
import com.example.VehicleServiceManagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findByVehicle(Vehicle vehicle);
}
