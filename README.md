# 🎓 Campus Event Manager – Backend

A robust backend system for managing campus events, built using **Spring Boot**, **Spring Security**, and **JWT Authentication**.
This project provides APIs for user authentication, event management, and event registrations with role-based access control.

---

# 🚀 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Security**
* **JWT Authentication**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **BCrypt Password Encryption**
* **Maven**
* **Postman (API Testing)**

---

# 📂 Project Architecture

The project follows a **layered architecture** for better scalability and maintainability.

```
src/main/java/com/campus/eventmanager

config
 └ SecurityConfig

controller
 ├ AuthController
 ├ UserController
 ├ EventController
 ├ RegistrationController
 └ AdminController

dto
 ├ UserDTO
 ├ EventDTO
 └ RegistrationDTO

mapper
 ├ UserMapper
 ├ EventMapper
 └ RegistrationMapper

model
 ├ User
 ├ Event
 ├ Registration
 └ Role

repository
 ├ UserRepository
 ├ EventRepository
 └ RegistrationRepository

service
 ├ UserService
 ├ EventService
 └ RegistrationService

security
 ├ JwtFilter
 ├ JwtUtil
 └ CustomUserDetailsService

exception
 └ GlobalExceptionHandler
```

---

# 🗄 Database Schema

### Users Table

Stores user information and roles.

| Field    | Type                      |
| -------- | ------------------------- |
| id       | Long                      |
| name     | String                    |
| email    | String                    |
| password | String                    |
| role     | ADMIN / FACULTY / STUDENT |

---

### Events Table

Stores event details.

| Field       | Type     |
| ----------- | -------- |
| id          | Long     |
| title       | String   |
| description | String   |
| eventDate   | DateTime |
| capacity    | Integer  |
| location    | String   |

---

### Registrations Table

Stores event registration records.

| Field            | Type     |
| ---------------- | -------- |
| id               | Long     |
| user_id          | FK       |
| event_id         | FK       |
| registrationDate | DateTime |

---

# 🔗 Entity Relationships

```
User (1) -------- (Many) Registrations

Event (1) -------- (Many) Registrations
```

---

# 🔐 Authentication & Authorization

This project uses **JWT-based authentication**.

### Login Flow

1. User logs in with email and password
2. Spring Security authenticates credentials
3. JWT token is generated
4. Token is used to access secured APIs

---

# 👥 User Roles

| Role    | Permissions                         |
| ------- | ----------------------------------- |
| ADMIN   | Manage events, users, registrations |
| FACULTY | Create and manage events            |
| STUDENT | Register for events                 |

---

# 📡 API Endpoints

## Authentication

### Register User

```
POST /api/auth/register
```

### Login

```
POST /api/auth/login
```

---

## Events

### Create Event

```
POST /api/events
```

### Get All Events

```
GET /api/events
```

### Get Event By ID

```
GET /api/events/{id}
```

### Delete Event

```
DELETE /api/events/{id}
```

---

## Event Registration

### Register For Event

```
POST /api/events/{eventId}/register
```

### Cancel Registration

```
DELETE /api/events/{eventId}/register
```

### Get All Registrations For Event

```
GET /api/events/{eventId}/registrations
```

---

# 🧪 API Testing

APIs can be tested using:

* **Postman**
* **cURL**
* **Swagger (optional future integration)**

Example Request:

```json
POST /api/auth/register

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "123456",
  "role": "STUDENT"
}
```

---

# ⚙️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/yourusername/campus-event-manager.git
```

### 2️⃣ Navigate to Project Folder

```
cd campus-event-manager
```

### 3️⃣ Build the Project

```
mvn clean install
```

### 4️⃣ Run the Application

```
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

# ✨ Features Implemented

* JWT Authentication
* Role-Based Authorization
* Event CRUD APIs
* Event Registration System
* DTO Architecture
* Mapper Layer
* Password Encryption with BCrypt
* Global Exception Handling
* Validation using Jakarta Validation

---

# 📈 Future Improvements

* Pagination & Sorting APIs
* Swagger API Documentation
* Standard API Response Wrapper
* Event Search & Filtering
* Email Notifications
* Docker Deployment

---

# 👨‍💻 Author

**Abhinay Srivastava**

B.Tech Computer Science Student
Backend Developer | Java | Spring Boot

GitHub:
https://github.com/Abhinay-Devil

---

# ⭐ If you like this project

Give it a ⭐ on GitHub and feel free to contribute!
