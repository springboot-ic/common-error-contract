# Common Error Contract

A standardized error response contract library for Spring Boot applications. This library provides a unified structure for error handling and reporting across microservices.

## Overview

This project defines a common error contract that can be used across multiple Spring Boot applications to ensure consistent error responses and proper error categorization.

## Features

- **Unified Error Response Structure**: Standardized `ApiError` contract for all error responses
- **Error Categorization**: Built-in error categories (GENERIC, VALIDATION, BUSINESS, SECURITY, SYSTEM)
- **Extensible Error Codes**: Interface-based error code implementation for custom error codes
- **Error Details**: Support for detailed error information with optional error details list
- **Distributed Tracing**: Built-in trace ID support for request tracking
- **Timestamp Tracking**: Automatic timestamp capture for all errors

## Project Information

- **GroupId**: `com.ic.springboot.errors`
- **ArtifactId**: `contract`
- **Version**: `1.0.0`
- **Java Version**: 17
- **Build Tool**: Maven

## Core Components

### ApiError (Record)
The main error response structure with the following fields:
- `code` - Error code implementing the `ErrorCode` interface
- `message` - Human-readable error message
- `category` - Error category (enum: GENERIC, VALIDATION, BUSINESS, SECURITY, SYSTEM)
- `service` - Name of the service that generated the error
- `traceId` - Unique trace ID for request tracking
- `timestamp` - When the error occurred
- `errors` - Optional list of detailed error information

### ErrorCode (Interface)
Interface for implementing custom error codes:
```java
public interface ErrorCode {
    String code();
}
```

### ErrorCategory (Enum)
Predefined error categories:
- `GENERIC` - Generic/uncategorized errors
- `VALIDATION` - Validation errors
- `BUSINESS` - Business logic errors
- `SECURITY` - Security-related errors
- `SYSTEM` - System/infrastructure errors

### ErrorDetail
Contains additional information about specific errors (when applicable)

### CommonErrorCode
Provides common error codes for standard scenarios

## Installation

### Maven

Add this to your `pom.xml`:
```xml
<dependency>
    <groupId>com.ic.springboot.errors</groupId>
    <artifactId>contract</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage Example

```java
import com.ic.springboot.errors.contract.*;
import java.time.Instant;

// Create a custom error code
public enum MyErrorCode implements ErrorCode {
    USER_NOT_FOUND("ERR_001"),
    INVALID_INPUT("ERR_002");
    
    private final String code;
    
    MyErrorCode(String code) {
        this.code = code;
    }
    
    @Override
    public String code() {
        return this.code;
    }
}

// Create an error response
ApiError error = new ApiError(
    MyErrorCode.USER_NOT_FOUND,
    "User with ID 123 was not found",
    ErrorCategory.BUSINESS,
    "user-service",
    "abc123def456",
    Instant.now(),
    null
);
```

## Building the Project

```bash
mvn clean package
```

## Publishing to Repository

This project is configured to publish to a custom Maven repository (Repsy). The GitHub Actions workflow automatically deploys to the repository on push to the main branch.

### Prerequisites for Publishing
1. GitHub secrets configured:
   - `REPSY_USERNAME` - Your Repsy username
   - `REPSY_TOKEN` - Your Repsy authentication token

### Manual Deployment
```bash
mvn deploy -DrepositoryId=repsy
```

## Contributing

When adding new features to this contract:
1. Ensure backward compatibility with existing implementations
2. Update the version in `pom.xml` following semantic versioning
3. Add appropriate error codes/categories as needed
4. Update this README with any new features

## License

[Add your license information here]

## Contact

For questions or issues, please contact the development team.

