package com.example.VehicleServiceManagement.repository;

import com.example.VehicleServiceManagement.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
