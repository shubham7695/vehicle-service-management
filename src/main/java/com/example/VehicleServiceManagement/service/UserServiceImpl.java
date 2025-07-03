package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }
    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
