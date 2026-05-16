# Customer Relationship Management (CRM) Application

A production-style full-stack CRM application built using Spring Boot that allows users to manage customer data with features such as CRUD operations, search, pagination, sorting, and REST APIs.

---

## Features

- Create, Read, Update, Delete (CRUD) Customer data
- Search customers by first name, last name, or email
- Pagination and sorting support
- Authentication using Spring Security
- REST APIs (tested with Postman)
- UI using Thymeleaf
- MySQL database integration

---

## Tech Stack

- Backend: Spring Boot, Spring MVC
- Database: MySQL
- ORM: Spring Data JPA (Hibernate)
- Frontend: Thymeleaf, HTML, CSS
- Security: Spring Security
- Build Tool: Maven
- API Testing: Postman
- Deployment: Render, Railway

---

## Project Structure

com.example.crm  
├── config        (Security configuration)  
├── controller    (UI and REST controllers)  
├── service       (Business logic)  
├── repository    (Database access layer)  
├── entity        (JPA entities)  
├── dto           (Data Transfer Objects)

---

## Live Demo

https://crm-application-suud.onrender.com/

Note: The live demo may take 30–60 seconds to load initially due to free-tier hosting cold starts.

---

## Deployment

Frontend + Backend hosted on Render  
Cloud MySQL database hosted on Railway

---

## Setup Instructions

### 1. Clone the repository

git clone https://github.com/AishwaryaGanesh99/Customer_Relationship_Manager.git  
cd Customer_Relationship_Manager

---

### 2. Configure MySQL

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
spring.jpa.hibernate.ddl-auto=update

Replace the placeholders with your local MySQL configuration.

---

### 3. Run the application

mvn spring-boot:run

---

### 4. Access the application

UI: http://localhost:8080

Login credentials:  
Username: admin  
Password: admin123

---

## API Endpoints

Base URL: http://localhost:8080/api/customers

GET    /api/customers        -> Get all customers (paginated)  
GET    /api/customers/{id}   -> Get customer by ID  
POST   /api/customers        -> Create customer  
PUT    /api/customers/{id}   -> Update customer  
DELETE /api/customers/{id}   -> Delete customer

---

## Sample Request (POST)

{
"firstName": "Aishwarya",
"lastName": "Ganesh",
"email": "aish@test.com"
}

---

## Key Highlights

- Combined search and pagination efficiently
- Layered architecture (Controller → Service → Repository)
- Supports both UI and REST APIs
- Secured using Spring Security
- Tested using Postman

---

## Production Features

- Cloud deployment using Render and Railway
- Pagination and server-side search optimization
- Layered architecture following industry-standard design
- RESTful API design
- Form-based authentication using Spring Security
- Persistent cloud-hosted MySQL database
- Environment variable based configuration for deployment

---

## Future Improvements

- Docker-based deployment
- CI/CD pipeline integration
- Role-based access control
- JWT-based authentication

---

## Author

Aishwarya 
https://github.com/AishwaryaGanesh99