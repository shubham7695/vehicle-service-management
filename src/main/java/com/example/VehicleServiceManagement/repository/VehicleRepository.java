package com.example.VehicleServiceManagement.repository;

import com.example.VehicleServiceManagement.model.Vehicle;
import com.example.VehicleServiceManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByOwner(User owner);

    //List<Vehicle> findByUser(User owner);
}
