# 🎓 Campus Event Manager (Backend)

A robust backend system for managing campus events, built using Spring Boot.
This project supports event creation, registration, authentication, and role-based access control.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Lombok
* Swagger (OpenAPI)

---

## 🏗️ Architecture

Layered Architecture:

* **Config** → SecurityConfig
* **Controller** → AuthController, UserController, EventController, RegistrationController, AdminController
* **DTO** → UserDTO, EventDTO, RegistrationDTO
* **Mapper** → UserMapper, EventMapper, RegistrationMapper
* **Model** → User, Event, Registration, Role
* **Repository** → UserRepository, EventRepository, RegistrationRepository
* **Service** → UserService, EventService, RegistrationService
* **Security** → JwtFilter, JwtUtil, CustomUserDetailsService
* **Exception** → GlobalExceptionHandler
* **Response** → ApiResponse

---

## 🗄️ Database Design

### Tables:

* users
* events
* registrations

### Relationships:

* One User → Many Registrations
* One Event → Many Registrations

---

## ✨ Features

### 🔐 Authentication & Authorization

* User Registration
* Login with JWT
* Password encryption using BCrypt
* Role-based access (ADMIN, FACULTY, STUDENT)

---

### 📅 Event Management

* Create, Update, Delete Events
* View Events with Pagination & Sorting
* Event Search & Filtering (JPA Specification)

---

### 📝 Registration System

* Register for Events
* Cancel Registration
* Duplicate registration prevention
* Event capacity validation

---

### ⚙️ Backend Enhancements

* DTO + Mapper Architecture
* Global Exception Handling
* Input Validation (Jakarta Validation)
* Standard API Response Structure
* Swagger API Documentation

---

## 🔍 Event Search & Filtering

Supports dynamic filtering using JPA Specification:

* Search by keyword (title)
* Filter by location
* Filter by date
* Pagination & sorting support

---

## 🧪 API Testing

Swagger UI available at:

http://localhost:8080/swagger-ui/index.html

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd YOUR_REPO
```

### 2️⃣ Configure Database (PostgreSQL)

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3️⃣ Run the project

```bash
mvn spring-boot:run
```

---

## 📌 Future Improvements

* Admin Analytics Dashboard
* Advanced Filtering (date range, category, etc.)
* Logging (SLF4J)
* Unit & Integration Testing
* Docker Deployment

---

## 👨‍💻 Author

Abhinay Srivastava

Backend Developer (Java | Spring Boot)
