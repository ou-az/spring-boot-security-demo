# Docker Commands Reference Guide

This document provides a reference for essential Docker commands used in the containerization of a Spring Boot application with a login screen. These commands demonstrate expertise with Docker containerization which is particularly relevant for DevOps and Cloud Engineering positions.

## Verifying Docker Installation

```bash
# Check Docker version
docker -v
```
Output:
```
Docker version 27.5.1, build 9f9e405
```

```bash
# Check detailed Docker info
docker info
```
Output will show client and server information including:
- Container and image counts
- Storage driver details
- Runtime configuration
- Resource limits
- Network settings

## Troubleshooting Docker Daemon

When encountering connection issues with Docker:

```bash
# Error example
docker build -t spring-security-demo .
ERROR: error during connect: Head "http://%2F%2F.%2Fpipe%2FdockerDesktopLinuxEngine/_ping": open //./pipe/dockerDesktopLinuxEngine: The system cannot find the file specified.
```

Troubleshooting steps:
1. Check if Docker daemon is running
2. Restart Docker Desktop
3. Verify connectivity by pulling a small test image:

```bash
# Test Docker Hub connectivity
docker pull hello-world
```
Output:
```
Using default tag: latest
latest: Pulling from library/hello-world
e6590344b1a5: Pull complete
Digest: sha256:c41088499908a59aae84b0a49c70e86f4731e588a737f1637e73c8c09d995654
Status: Downloaded newer image for hello-world:latest
docker.io/library/hello-world:latest
```

## Finding and Using Docker Images

```bash
# Search for available Maven images
docker search maven --limit 5
```
Output:
```
NAME                     DESCRIPTION                                     STARS     OFFICIAL
maven                    Apache Maven is a software project managemen…   1628      [OK]
okteto/maven                                                             0
chainguard/maven         Build, ship and run secure software with Cha…   0
atlassian/maven          Apache Maven running under a pre-created non…   6
paketobuildpacks/maven                                                   0
```

```bash
# Pull specific images
docker pull maven:latest
docker pull eclipse-temurin:17-jre
```

## Dealing with Image Tag Issues

When encountering non-existent image tags:

```bash
# Error example
docker pull maven:3.8.6-openjdk-17-slim
Error response from daemon: manifest for maven:3.8.6-openjdk-17-slim not found: manifest unknown: manifest unknown
```

Solution: Update Dockerfile to use available tags:
```dockerfile
# Before
FROM maven:3.8.6-openjdk-17-slim AS build

# After
FROM maven:latest AS build
```

## Building Docker Images

```bash
# Build Docker image with a tag
docker build -t spring-security-demo .
```

The multi-stage build process demonstrated:
1. Build stage using Maven to compile the application
2. Runtime stage using JRE for a smaller final image
3. Security hardening with non-root user
4. Health checks and proper resource configuration

## Running Containers

```bash
# Run container in detached mode with port mapping
docker run -d -p 8080:8080 --name spring-security-app spring-security-demo
```

## Container Management

```bash
# View running containers
docker ps

# View all containers (including stopped)
docker ps -a
```

```bash
# Check container logs
docker logs spring-login-demo
```

Output will show application startup information and request logs.

## Container Lifecycle Management

```bash
# Stop a running container
docker stop spring-login-demo
```

```bash
# Remove a stopped container
docker rm spring-login-demo
```

```bash
# Remove a Docker image
docker rmi spring-security-demo
```

## Clean-up Operations

```bash
# Remove all stopped containers
docker container prune
```
Output will confirm deleted containers and space reclaimed.

```bash
# Check Docker disk usage
docker system df
```
Output:
```
TYPE            TOTAL     ACTIVE    SIZE      RECLAIMABLE
Images          27        0         2.568GB   2.568GB (100%)
Containers      0         0         0B        0B
Local Volumes   1         0         0B        0B
Build Cache     73        0         186.1MB   186.1MB
```

## Best Practices Demonstrated

1. **Multi-stage builds** for optimized image size
2. **Security hardening** with non-root users
3. **Proper tagging** and naming conventions
4. **Resource management** and cleanup
5. **Troubleshooting** connection and registry issues
6. **Version management** of base images

These Docker commands and practices are highly relevant for DevOps and Cloud Engineering positions that require container orchestration expertise.
