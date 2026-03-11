# 🎓 Campus Event Manager

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Project-In%20Development-yellow)

A **Campus Event Management Backend System** built with **Spring Boot and PostgreSQL**.
This project provides APIs for managing users, events, and registrations in a campus environment.

---

# 🚀 Features

### 👤 User Management

* Create new users
* Fetch all users
* Unique email validation
* Role-based users (ADMIN, STUDENT, FACULTY)

### 🔐 Security

* Password encryption using **BCrypt**
* Password hidden in API responses
* Spring Security integration

### ⚠ Error Handling

* Custom exceptions
* Global exception handling
* Clean API error responses

### ⏱ Automatic Timestamps

* User creation time stored automatically
* Hibernate timestamp annotations

### 🗄 Database

* PostgreSQL database
* ORM using JPA / Hibernate

---

# 🏗 Project Architecture

```id="xfj3jt"
Controller
   ↓
Service
   ↓
Repository
   ↓
Database (PostgreSQL)
```

The project follows **Layered Architecture**, which is widely used in enterprise applications.

---

# 📂 Project Structure

```id="ykg9u3"
src/main/java/com/campus/eventmanager

├── config          # Security configuration
├── controller      # REST API controllers
├── exception       # Custom exceptions & handlers
├── model           # Entity classes
├── repository      # Database repositories
├── service         # Business logic
└── EventmanagerApplication.java
```

---

# 📡 API Endpoints

## Create User

```id="6rtk2o"
POST /api/users
```

Request Body:

```json id="h0qlxy"
{
  "name": "Rahul",
  "email": "rahul@test.com",
  "password": "1234",
  "role": "STUDENT"
}
```

Response:

```json id="o39t0c"
{
  "id": 1,
  "name": "Rahul",
  "email": "rahul@test.com",
  "role": "STUDENT",
  "createdAt": "2026-03-05T23:55:10"
}
```

---

## Get All Users

```id="f4u9k3"
GET /api/users
```

Example Response:

```json id="yl5woe"
[
  {
    "id": 1,
    "name": "Rahul",
    "email": "rahul@test.com",
    "role": "STUDENT"
  }
]
```

---

# 🗄 Database Example

Users Table:

| id | name  | email                                   | password  | role    | created_at |
| -- | ----- | --------------------------------------- | --------- | ------- | ---------- |
| 1  | Rahul | [rahul@test.com](mailto:rahul@test.com) | encrypted | STUDENT | timestamp  |

---

# ⚙ Setup & Run

### 1️⃣ Clone Repository

```id="toocvi"
git clone https://github.com/yourusername/campus-event-manager.git
```

### 2️⃣ Open Project

```id="t7n5n9"
cd campus-event-manager
```

### 3️⃣ Run Application

```id="9q2jcv"
.\mvwn spring-boot:run
```

---

# 🧪 API Testing

You can test APIs using:

* Postman
* Thunder Client
* curl

---

# 🔮 Future Improvements

* JWT Authentication
* Login System
* Role-based authorization
* Event creation APIs
* Event registration system
* Admin dashboard APIs

---

# 👨‍💻 Author

**Abhinay Srivastava**

Fullstack Developer
Java | Spring Boot | PostgreSQL
