package com.example.VehicleServiceManagement.security;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminUserConfig {

    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminUsername = "admin";
            String adminEmail = "admin@example.com";

            boolean adminExists = userRepository.existsByUsername(adminUsername) || userRepository.existsByEmail(adminEmail);
            if (!adminExists) {
                User admin = new User();
                admin.setUsername(adminUsername);
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("admin123"));  // Change strong password after first login!
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println("Default admin user created.");
            }
        };
    }
}