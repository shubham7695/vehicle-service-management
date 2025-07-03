package com.example.VehicleServiceManagement.service;

import com.example.VehicleServiceManagement.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    boolean userExists(String username);
    boolean emailExists(String email);

}
