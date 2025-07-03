package com.example.VehicleServiceManagement.service.impl;

import com.example.VehicleServiceManagement.model.Mechanic;
import com.example.VehicleServiceManagement.repository.MechanicRepository;
import com.example.VehicleServiceManagement.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicServiceImpl implements MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    @Override
    public Mechanic findById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    @Override
    public Mechanic save(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    @Override
    public void deleteById(Long id) {
        mechanicRepository.deleteById(id);
    }
}
