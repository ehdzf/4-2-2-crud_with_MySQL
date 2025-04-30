# Fruits API

A Spring Boot REST API for managing fruits inventory with MongoDB as the database.

## Project Description

This application provides a simple CRUD (Create, Read, Update, Delete) API for managing fruits. It allows you to:
- Get a list of all fruits
- Add new fruits to the inventory
- Get details of a specific fruit
- Update fruit information
- Delete fruits from the inventory

## Prerequisites

- Java 21
- Gradle
- MongoDB (running on localhost:27017)

## Setup Instructions

### 1. Clone the repository

```bash
git clone <repository-url>
cd <repository-directory>
```

### 2. Configure MongoDB

Make sure MongoDB is installed and running on your system. The application is configured to connect to:
- Host: localhost
- Port: 27017
- Database: fruits
- Password: secret

You can modify these settings in `src/main/resources/application.properties` if needed.

### 3. Build the application

```bash
./gradlew build
```

### 4. Run the application

```bash
./gradlew bootRun
```

The application will start on the default port 8080.

## API Endpoints

### Get all fruits
- **URL**: `/fruits`
- **Method**: GET
- **Response**: List of all fruits
- **Status Code**: 200 OK

### Create a new fruit
- **URL**: `/fruits`
- **Method**: POST
- **Request Body**: Fruit object (JSON)
- **Response**: Created fruit with ID
- **Status Code**: 201 CREATED

Example request body:
```json
{
  "name": "Apple",
  "quantity": 10
}
```

### Get a specific fruit
- **URL**: `/fruits/{id}`
- **Method**: GET
- **URL Params**: id (String)
- **Response**: Fruit object
- **Status Code**: 200 OK

### Update a fruit
- **URL**: `/fruits/{id}`
- **Method**: PATCH
- **URL Params**: id (String)
- **Request Body**: Fruit object (JSON)
- **Status Code**: 200 OK

Example request body:
```json
{
  "name": "Apple",
  "quantity": 15
}
```

### Delete a fruit
- **URL**: `/fruits/{id}`
- **Method**: DELETE
- **URL Params**: id (String)
- **Status Code**: 200 OK

## Data Model

### Fruit

| Field    | Type   | Description                    |
|----------|--------|--------------------------------|
| id       | String | Unique identifier (MongoDB ID) |
| name     | String | Name of the fruit              |
| quantity | int    | Quantity of the fruit          |

## Error Handling

The API includes exception handling for common errors:
- Fruit not found
- Invalid input data
- Server errors

## Technologies Used

- Spring Boot 3.4.4
- Spring Data MongoDB
- Java 21
- Gradle
- JUnit for testing
