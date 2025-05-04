# Contributing to Spring Boot Security Demo

Thank you for considering contributing to this project! This document outlines the process for contributing to the Spring Boot Security Demo project.

## Code of Conduct

By participating in this project, you agree to maintain a respectful and inclusive environment for everyone.

## How to Contribute

### Reporting Issues

If you find a bug or have a suggestion for improvement:

1. First, check if the issue already exists in the [GitHub Issues](https://github.com/yourusername/spring-boot-security-demo/issues)
2. If not, create a new issue with a clear title and description
3. Include steps to reproduce the issue and any relevant logs or screenshots
4. Add appropriate labels (bug, enhancement, documentation, etc.)

### Submitting Changes

1. Fork the repository
2. Create a new branch from `main` for your changes
   ```
   git checkout -b feature/your-feature-name
   ```
3. Make your changes and commit with clear, descriptive messages
4. Ensure all tests pass and add new tests for new functionality
5. Push your branch to your fork
6. Submit a pull request to the `main` branch

### Pull Request Process

1. Ensure your PR includes a clear description of the changes
2. Link any relevant issues using GitHub keywords (fixes #123, closes #456)
3. Update documentation as needed
4. Make sure CI checks pass on your PR
5. Request review from maintainers
6. Address any feedback from code reviews

## Development Setup

### Prerequisites

- Java 17
- Maven 3.8+
- Docker and Docker Compose

### Local Development

```bash
# Clone your fork
git clone https://github.com/yourusername/spring-boot-security-demo.git
cd spring-boot-security-demo

# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```

### Docker Development

```bash
# Build and run with Docker
docker build -t spring-security-demo .
docker run -p 8080:8080 spring-security-demo
```

## Coding Standards

- Follow standard Java coding conventions
- Use meaningful variable and method names
- Include JavaDoc comments for public methods
- Keep methods small and focused on a single responsibility
- Write unit tests for all new functionality

## License

By contributing to this project, you agree that your contributions will be licensed under the MIT license that covers this project.

Thank you for your contributions!
