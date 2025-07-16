# Spring Boot JWT Authentication

This project demonstrates how to implement **JWT-based authentication** in a Spring Boot application using:
- `Spring Security`
- `UserDetailsService`
- `JWT Token (jjwt)`
- `AuthenticationManager`
- `Custom Filter` for token validation

## 📌 Features

- ✅ Register new users
- ✅ Login and receive JWT token
- ✅ Access protected endpoints using JWT
- ✅ Stateless session management
- ✅ Password encryption using BCrypt
- ✅ Clean code structure with service, repository, and config layers

## 📂 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security
- Spring Web
- Spring Data JPA
- MySQL
- JJWT (JWT library)


## 🔑 Authentication Flow

1. **POST `/employees/register`**
   - Register a new user (employee)
   - Stores name and password (BCrypt encoded)

2. **POST `/employees/login`**
   - Accepts name & password
   - If valid, returns JWT token (e.g., `Bearer eyJhbGciOi...`)

3. **GET `/employees/getAll` or `/profile`**
   - Protected APIs
   - Require valid JWT token in the header:
     ```
     Authorization: Bearer <your-token>
     ```


