package com.eureka.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // Enabling Eureka Server functionality
public class EurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		  // Print a message before running the application
        System.out.println("Starting Eureka Discovery Server...");

        // Run the Spring Boot application
        SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
        
        // Print a message after the application starts
        System.out.println("Eureka Discovery Server is running!");
	}

}
