# 🏗️ Microservices Architecture with Spring Boot  

This repository (`MicroservicesDemo`) contains multiple **Spring Boot-based microservices**, each handling a specific functionality. These services communicate with each other, forming a complete **distributed system**.

## 📌 Overview  

This project follows the **Microservices Architecture** pattern, where each service is independently developed, deployed, and maintained. Below are the main services in this repository:

| 🏷️ **Service Name**  | 🔍 **Description** |
|--------------------|-----------------|
| 📚 **Library Service** | Manages the library system, including book records and transactions. |
| 📖 **Book Service** | Handles book-related operations like adding, updating, and searching books. |
| 🏫 **Student Service** | Manages student data, including borrowing and returning books. |
| 🔀 **API Gateway** | Acts as the entry point for all requests, handling authentication, rate limiting, and routing. |
| ⚡ **Eureka Server** | Service Discovery component that registers and locates services dynamically. |

## 🛠️ **Tech Stack**  

- **Spring Boot** (Microservices Framework)  
- **Spring Cloud Netflix Eureka** (Service Discovery)  
- **Spring Cloud Gateway** (API Gateway)  
- **Spring Data JPA** (Database Access)  
- **H2 / MySQL / PostgreSQL** (Database)  
- **Docker & Kubernetes** (Containerization & Orchestration)  
- **Swagger** (API Documentation)  

## 🔄 **How the Microservices Interact**  

1️⃣ **Eureka Server** registers and manages all microservices.  
2️⃣ **API Gateway** routes requests to appropriate microservices.  
3️⃣ **Library Service** interacts with **Book Service** & **Student Service** to manage book transactions.  
4️⃣ Each microservice communicates via **REST APIs**.  

## 🚀 **How to Run the Services**  

### **1️⃣ Clone the Repository**  
```sh
git clone https://github.com/your-username/microservices.git
cd microservices
