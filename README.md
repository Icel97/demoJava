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

### Filtering Specification
GET /users?filter=field+operator+value

This endpoint allows filtering users using the following format:
    /users?filter=field+operator+value

Where:
    
    field → One of:
    email | id | name | phone | tax_id | created_at

operator → One of:
    co (contains)
    eq (equals)
    sw (starts with)
    ew (ends with)

value → The value to compare against.

⚠ Important Note About URL Encoding
According to the HTTP specification, the + character in query parameters is interpreted as a space unless it is URL-encoded.
Therefore, when calling this endpoint, the + symbol must be encoded as:

    %2B
    Correct Usage Example
    GET /users?filter=name%2Bco%2Buser

📘 Examples

    Description	Request
    Name contains "user"	/users?filter=name%2Bco%2Buser
    Email ends with "mail.com"	/users?filter=email%2Bew%2Bmail.com
    Phone starts with "555"	/users?filter=phone%2Bsw%2B555
    Tax ID equals AARR990101XXX	/users?filter=tax_id%2Beq%2BAARR990101XXX

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