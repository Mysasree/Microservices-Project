# 🏨 Hotel Rating System – Microservices Project

This project is a microservices-based hotel rating system built with Spring Boot and Spring Cloud.
The project demonstrates inter-service communication, service discovery, centralized configuration, and routing using an API Gateway.

---

## 📁 Project Modules

- **UserService**: Manages users and fetches their ratings.
- **RatingService**: Manages ratings.
- **HotelService**: Manages hotel details.
- **API Gateway**: Routes requests to appropriate services.
- **Service Registry (Eureka)**: Registers all services for discovery.
- **Config Server**: Centralized configuration for all services.

---

## 🧰 Tech Stack

- Java 8
- Spring Boot
- Spring Cloud (Eureka, Config Server, Gateway)
- Spring Data JPA
- MySQL

---

## 🔁 Microservice Flow

1. **UserService** calls **RatingService** to get user ratings.
2. **RatingService** calls **HotelService** to get hotel info related to the ratings.
3. All requests go through **API-Gateway**.
4. All services are registered with **ServiceRegistry (Eureka)**.
5. Configs are loaded from **Config-Server**.

---

### 🗂 Prerequisites:
- Java 8+
- MySQL

---

## ▶️ Running the Project

1. Clone the repo.
2. Create MySQL databases for each service.
3. Start Eureka Server, Config Server, API Gateway, then the microservices (Hotel, Rating, User) one by one.
4. Use Maven commands (mvn spring-boot:run) to run each service.

---

## Author

Mysasree Jillala  
[GitHub Profile](https://github.com/Mysasree)
