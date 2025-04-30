# Fruits CRUD API with Spring Boot and MySQL

This project is a RESTful API for managing fruits inventory using Spring Boot and MySQL. It provides basic CRUD operations for fruits.

## Project Description

The Fruits CRUD API allows you to:
- Create new fruits with name and quantity
- Retrieve all fruits or a specific fruit by ID
- Update existing fruits
- (Note: Delete functionality is implemented in the service layer but not exposed as an endpoint)

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- MySQL 8
- Gradle

## Configuration

The application is configured to connect to a MySQL database. The configuration can be found in `src/main/resources/application.properties`:

```properties
spring.application.name=S04T02N02
spring.datasource.url=jdbc:mysql://localhost:3307/fruits
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=secret
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Database Setup

1. Ensure you have MySQL installed and running on port 3307
2. Create a database named `fruits`
3. The application will automatically create the necessary tables when it starts

## API Endpoints

### Get All Fruits
- **URL**: `/fruits`
- **Method**: GET
- **Response**: List of all fruits
- **Status Code**: 200 OK

### Get Fruit by ID
- **URL**: `/fruits/{id}`
- **Method**: GET
- **URL Params**: `id=[long]`
- **Response**: Single fruit object
- **Status Code**: 200 OK
- **Error Response**: 
  - Status Code: 404 Not Found (if fruit doesn't exist)

### Create Fruit
- **URL**: `/fruits`
- **Method**: POST
- **Request Body**: Fruit object
  ```json
  {
    "name": "Apple",
    "quantity": 100
  }
  ```
- **Response**: Created fruit object with ID
- **Status Code**: 201 Created

### Update Fruit
- **URL**: `/fruits/{id}`
- **Method**: PATCH
- **URL Params**: `id=[long]`
- **Request Body**: Fruit object with updated fields
  ```json
  {
    "name": "Green Apple",
    "quantity": 150
  }
  ```
- **Response**: None
- **Status Code**: 200 OK
- **Error Response**: 
  - Status Code: 404 Not Found (if fruit doesn't exist)

## Data Model

### Fruit
- **id**: long (auto-generated)
- **name**: String
- **quantity**: int

## Running the Application

### Prerequisites
- Java 21
- MySQL 8 running on port 3307

### Steps
1. Clone the repository
2. Configure the database connection in `application.properties` if needed
3. Run the application:
   ```
   ./gradlew bootRun
   ```
4. The API will be available at `http://localhost:8080`

## Testing
Run the tests using:
```
./gradlew test
```
