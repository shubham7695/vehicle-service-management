package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.ServiceRequest;
import com.example.VehicleServiceManagement.model.Vehicle;
import com.example.VehicleServiceManagement.repository.ServiceRequestRepository;
import com.example.VehicleServiceManagement.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Override
    public List<ServiceRequest> getAll() {
        return serviceRequestRepository.findAll();
    }

    @Override
    public List<ServiceRequest> findByVehicle(Vehicle vehicle) {
        return serviceRequestRepository.findByVehicle(vehicle);
    }

    @Override
    public ServiceRequest findById(Long id) {
        return serviceRequestRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceRequest save(ServiceRequest request) {
        return serviceRequestRepository.save(request);
    }

    @Override
    public void deleteById(Long id) {
        serviceRequestRepository.deleteById(id);
    }
}
