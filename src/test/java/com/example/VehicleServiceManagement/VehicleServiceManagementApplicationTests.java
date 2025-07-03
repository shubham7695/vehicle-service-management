package com.example.VehicleServiceManagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class VehicleServiceManagementApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().matches("admin123", "$2a$10$Dow1i9UCaFS1r8dL1GAYnugEqPSqvGoY4CskAi2MTcY3mGoVDhUXi"));
	}

}
