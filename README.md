# MovieBox Platform

MovieBox is a **cloud-native, microservices-based movie ticket booking system** built with Spring Boot. It features dynamic seat locking, real-time concurrency management, and is fully Dockerized for scalable orchestration. The platform is designed for reliability, modularity, and high performance.

---

## 🚀 Features

- **Microservices Architecture:** Each business domain (location, theatre, screening, seat, gateway, registry) is a separate Spring Boot service.
- **Service Discovery:** Eureka-based service registry for dynamic service lookup.
- **API Gateway:** Centralized routing and load balancing using Spring Cloud Gateway.
- **Database Integration:** MySQL for persistent storage.
- **Message Broker:** RabbitMQ for asynchronous communication (seat locking, notifications, etc.).
- **Dynamic Seat Locking:** Adaptive seat timeout logic to prevent double booking.
- **Dockerized Deployment:** All services and dependencies run as containers via Docker Compose.
- **Scalable & Modular:** Easily add new features or scale services independently.

---

## 🏗️ Architecture

```
+-------------------+      +-------------------+      +-------------------+
|   API Gateway     |<---->| Service Registry  |<---->|   Microservices   |
+-------------------+      +-------------------+      +-------------------+
        |                        |                        |
        |                        |                        |
        v                        v                        v
   [Clients]               [Eureka]         [Location | Theatre | Screening | Seat]
        |
        v
   [RabbitMQ] <----> [Seat Service] <----> [MySQL]
```

---

## 📦 Microservices

- **Service-Registry:** Eureka server for service discovery.
- **API-Gateway:** Entry point for all client requests, routes to services.
- **Location-Service:** Manages city and location data.
- **Theatre-Service:** Handles theatres and their details.
- **Screening-Service:** Manages movie screenings and showtimes.
- **Seat-Service:** Handles seat availability, locking, and booking.

---

## 🐳 Dockerized Deployment

### Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop)
- [Java 17+](https://adoptopenjdk.net/) (for local builds)
- [Maven](https://maven.apache.org/) (for local builds)

### Quick Start

1. **Build all services:**

   ```sh
   # From each service directory (e.g., seat-service, location-service, etc.)
   ./mvnw clean package
   ```

2. **Start all services with Docker Compose:**

   ```sh
   docker-compose up --build
   ```

3. **Access the system:**
   - **API Gateway:** [http://localhost:8086](http://localhost:8086)
   - **Eureka Dashboard:** [http://localhost:8761](http://localhost:8761)
   - **RabbitMQ Management:** [http://localhost:15672](http://localhost:15672) (user: guest, pass: guest)
   - **MySQL:** [localhost:3306](localhost:3306) (user: root, pass: Lol0987##)

---

## ⚙️ Configuration

Each service uses Docker Compose service names for inter-service communication:

```properties
# Example (application.properties)
eureka.client.service-url.defaultZone=http://service-registry:8761/eureka/
spring.datasource.url=jdbc:mysql://mysql:3306/MOVIEBOX
spring.rabbitmq.host=rabbitmq
```

---

## 🧪 Testing

- Each service contains unit and integration tests.
- Run tests with:
  ```sh
  ./mvnw test
  ```

---

## 📁 Project Structure

```
MOVIEBOX/
│
├── Service-Registry/
├── API-Gateway/
├── location-service/
├── theatre-service/
├── screening-service/
├── seat-service/
├── docker-compose.yml
└── README.md
```

---

## 🤝 Contributing

1. Fork the repo
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

---

## 📜 License

This project is licensed under the MIT License.

---

## 🙏 Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Docker](https://www.docker.com/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [MySQL](https://www.mysql.com/)

---

> **MovieBox** – Scalable, reliable, and ready for the cloud!
