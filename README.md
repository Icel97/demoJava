# Demo Java API

REST API developed with Spring Boot for user management.

## 🚀 Technologies

- Java 17
- Spring Boot
- Maven
- Swagger / OpenAPI
- JUnit 5
- Docker

---

## 📌 Features

- Create user
- Validate unique Tax ID
- Password encryption
- In-memory data storage
- Unit tests
- OpenAPI documentation

---

## 📂 Project Structure

    src/
    ├── config
    ├── controller
    ├── service
    ├── dto
    ├── exception
    ├── model
    ├── validation
    └── util

---

## ▶️ Run the Project

### Option 1: Using Maven

```bash
    mvn clean install
    mvn spring-boot:run
```

Application will start at:
http://localhost:8080

Swagger UI available at:
http://localhost:8080/swagger-ui/index.html

### Option 2: Using Docker

```bash
    docker build -t demojava .
    docker run -p 8080:8080 demojava
```

## 🧪 Run Tests

```bash
    mvn test
```

Includes:

    Successful user creation test
    
    Duplicate Tax ID validation test

## Postman Collection
    A Postman collection is included in the project for testing the API endpoints. Import `postman_collection.json` into Postman to access predefined requests.

## Api Documentation
    API documentation is available via Swagger UI at http://localhost:8080/swagger-ui/index.html after running the application.

## Desing Decisions
    - Used Spring Boot for rapid development and ease of configuration.
    - In-memory storage used for simplicity.
    - Passwords are encrypted before storing.
    - Validation handled using annotations.
    - Clear separation between DTOs, services, and controllers.

## 📄 License 
    licensed under MIT License. See LICENSE file for details.

## Author
    Developed by Raul Isaac Candelario Escobar Lopez. Feel free to contribute or report issues!