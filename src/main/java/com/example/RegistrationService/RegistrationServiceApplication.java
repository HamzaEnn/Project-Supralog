package com.example.RegistrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * RegistrationServiceApplication class
 * 
 * Main application class for the Registration and Display Services
 * 
 */
@SpringBootApplication
@EnableMongoRepositories
public class RegistrationServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}
	
}
