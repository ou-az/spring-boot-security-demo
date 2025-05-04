# Spring Boot Docker Demo

[![Build Status](https://img.shields.io/github/workflow/status/yourusername/spring-boot-docker-demo/Spring%20Boot%20Docker%20Demo%20CI?style=flat-square)](https://github.com/yourusername/spring-boot-docker-demo/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg?style=flat-square&logo=docker)](https://www.docker.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-green.svg?style=flat-square&logo=spring)](https://spring.io/projects/spring-boot)

A production-ready Spring Boot application with security login screen, containerized with Docker for cloud deployment. This project demonstrates containerization expertise, CI/CD pipeline integration, and secure application deployment - skills required for senior DevOps and software engineering positions.

![Login Screen](docs/images/login-screenshot.png)

> Note: This project is part of a portfolio showcasing DevOps, containerization, and full-stack development skills.

## Features

- Spring Boot 3.4.5 with Java 17
- Spring Security with form-based authentication
- Thymeleaf templates with Bootstrap 5
- Multi-stage Docker build for optimized container size
- Docker Compose for local development
- Health checks and container monitoring
- Resource constraints and optimization

## Local Development

### Prerequisites
- Java 17
- Maven 3.8+
- Docker and Docker Compose

### Build and Run with Maven

```bash
# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```

The application will be available at [http://localhost:8080](http://localhost:8080)

### Default Users

- Regular user: username=`user`, password=`password`
- Admin user: username=`admin`, password=`admin`

## Docker Deployment

### Building the Docker Image

```bash
# Build the image
docker build -t spring-docker-demo .
```

### Running the Container

```bash
# Run the container
docker run -p 8080:8080 spring-docker-demo
```

### Using Docker Compose

```bash
# Build and start the application
docker-compose up -d

# View logs
docker-compose logs -f

# Stop the application
docker-compose down
```

## Container Features

This Docker deployment demonstrates several best practices:

1. **Multi-stage builds** - Separate build and runtime stages to reduce final image size
2. **Security hardening** - Running as non-root user
3. **Health checks** - Regular monitoring of application health
4. **Resource constraints** - CPU and memory limits to improve stability
5. **Environment configuration** - Externalized configuration via environment variables
6. **Volume mounting** - Persistent storage for logs
7. **Network isolation** - Custom bridge network


## Architecture

The application follows a standard Spring MVC architecture:
- **Controller Layer**: Handles HTTP requests and responses
- **Security Layer**: Manages authentication and authorization
- **View Layer**: Thymeleaf templates for rendering HTML
- **Configuration**: Externalized application settings

## Cloud Deployment Considerations

This application is designed for deployment to cloud platforms such as:

- Azure Container Instances
- Amazon ECS/EKS
- Google Cloud Run/GKE
- Kubernetes clusters


## Next Steps

- Implement CI/CD pipeline with Azure DevOps
- Add monitoring with Prometheus and Grafana
- Implement HTTPS with SSL certificates
- Add database persistence
- Add application metrics and tracing
