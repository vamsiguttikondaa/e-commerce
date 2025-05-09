# 🛒 E-Commerce Microservices Application

A full-fledged, scalable e-commerce application built using the **Microservices Architecture** with **Spring Boot**, **Spring Cloud**, **Docker**, **ReactJS**, **MySQL**, **RabbitMQ**, **Keycloak**, and **Kubernetes (optional)**. Follows real-world practices: REST APIs, service discovery, centralized config, API gateway, and CI/CD.

---

## 🧱 Architecture Overview

```
[Client] ⇄ [API Gateway] ⇄ [Microservices]
                         ⇄ Product Service
                         ⇄ User Service
                         ⇄ Order Service
                         ⇄ Inventory Service
                         ⇄ Payment Service
                         ⇄ Notification Service (Email/SMS)
                         ⇄ Auth Service (Keycloak / JWT)
```

---

## 📦 Microservices Breakdown

| Service           | Description                                              | Port  |
|------------------|----------------------------------------------------------|--------|
| `api-gateway`     | Entry point for all clients, uses Spring Cloud Gateway  | `8080` |
| `auth-service`    | Handles login/registration, built with Keycloak or JWT  | `8081` |
| `product-service` | Manages product listings, categories, pricing            | `8082` |
| `order-service`   | Handles order placement, status, invoice                 | `8083` |
| `inventory-service` | Tracks product stock levels, updates on purchase     | `8084` |
| `payment-service` | Mocks or integrates with payment gateways                | `8085` |
| `notification-service` | Sends email/SMS using RabbitMQ                    | `8086` |
| `config-service`  | Centralized config management using Spring Cloud Config | `8888` |
| `discovery-service` | Eureka server for service discovery                   | `8761` |

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Cloud
- **Frontend:** ReactJS, Tailwind CSS (Optional)
- **Database:** MySQL
- **Messaging Queue:** RabbitMQ
- **Auth:** Keycloak / JWT + Spring Security
- **Service Discovery:** Eureka
- **Central Config:** Spring Cloud Config
- **API Gateway:** Spring Cloud Gateway
- **DevOps:** Docker, Docker Compose, GitHub Actions
- **Deployment:** AWS EC2 / Render / Railway

---

## ⚙️ Run Locally

### 🐳 With Docker Compose

```bash
docker-compose up --build
```

### 🧪 Without Docker (Manually)

Start each service in its own terminal or via your IDE after setting `application.properties` with appropriate DB/config URLs.

---

## ✅ Features

- User registration & login (JWT or Keycloak)
- Product listing & filtering
- Cart management
- Order placement & status tracking
- Inventory sync after order
- Payment mock with success/fail states
- Notification emails via RabbitMQ
- Centralized configuration
- Eureka-based service discovery
- Docker-based environment
- GitHub Actions for CI/CD

---

## 🧪 Test Data

Use Postman or Swagger (configured in each service) to test endpoints.

---

## 🔐 Authentication

You can choose one:

- ✅ **JWT + Spring Security**
- ✅ **Keycloak** (preferred for production-level)

---

## 📁 Folder Structure

```
/ecommerce-microservices
├── api-gateway
├── auth-service
├── product-service
├── order-service
├── inventory-service
├── payment-service
├── notification-service
├── config-service
├── discovery-service
├── docker-compose.yml
└── README.md
```

---

## 🚀 Deployment

- CI/CD with GitHub Actions
- Deployed on AWS EC2 / Railway
- Frontend hosted on Vercel or Netlify

---

## 📌 Future Enhancements

- Real payment gateway (Razorpay, Stripe)
- Order analytics dashboard
- Redis caching
- Kubernetes deployment
- Rate limiting / Circuit Breaker (Resilience4j)

---

## 🙋‍♂️ Author

> Built by vamsi guttikonda as a real-world showcase of microservices skills.

---

## 📄 License

This project is licensed under the MIT License.
