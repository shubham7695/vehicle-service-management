package com.example.VehicleServiceManagement;

import com.example.VehicleServiceManagement.model.User;
import com.example.VehicleServiceManagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VehicleServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceManagementApplication.class, args);
		System.out.println("http://localhost:8080/");
	}

	}
