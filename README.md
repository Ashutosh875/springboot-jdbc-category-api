# Category Management REST API

## Tech Stack
- Java 
- Spring Boot
- PostgreSQL
- JDBC
- Maven

## Features
- Create category
- Get all categories
- Get category by ID
- Update category
- Delete category
- Global exception handling

## Architecture
Controller → Service → Repository → Database

## How To Run
1. Create PostgreSQL database
2. Update User-Name and Password
3. Run the application
4. Test endpoints using Postman

## Sample Endpoints

| Method | Endpoint            | Description |
|--------|---------------------|------------|
| POST   | api/categories      | Create category |
| GET    | api/categories      | Get all categories |
| GET    | api/categories/{id} | Get category by ID |
| PUT    | api/categories/{id} | Update category |
| DELETE | api/categories/{id} | Delete category |
