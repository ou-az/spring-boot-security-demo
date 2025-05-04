package com.example.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot Security Demo Application with JWT and OAuth2 Integration
 * 
 * This application demonstrates:
 * - Spring Security configuration with JWT token-based authentication
 * - OAuth2 integration with social login providers
 * - Role-based access control to secure endpoints
 * - Form-based authentication for web UI
 * - RESTful API authentication with JWT tokens
 * 
 * The application is containerized using Docker for easy deployment and scalability.
 */
@SpringBootApplication
public class DockerDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
        System.out.println("\n==============================================================");
        System.out.println("  Spring Boot Security Demo with JWT & OAuth2 is running!");
        System.out.println("  Access the application at: http://localhost:8080");
        System.out.println("  API endpoints available at: http://localhost:8080/api/*");
        System.out.println("==============================================================\n");
    }
}
