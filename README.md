# Employee Register

## Overview
The **Employee Register** is a full-stack application built using **Spring Boot** for the backend and a modern frontend framework (like React or Angular) for the user interface. This application allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records, demonstrating the principles of RESTful web services and effective project structuring.

## Features
- **User-Friendly Interface**: Intuitive UI for managing employee records.
- **CRUD Operations**: Add, view, edit, and delete employee details.
- **Database Integration**: Utilizes SQL with Hibernate for efficient data management.
- **RESTful API**: Exposes endpoints for seamless interaction between frontend and backend.
- **Error Handling**: Implements robust error handling to ensure a smooth user experience.
- **Dependency Injection**: Utilizes Spring's dependency injection for better application performance and testing.

## Project Setup
### Backend
1. **Spring Boot**: The backend is developed using Spring Boot, allowing for quick project setup and configuration.
2. **Database**: Configure your SQL database connection in `application.properties`.
3. **Dependencies**: Use Maven or Gradle for managing project dependencies.
4. **Run the Application**: Start the application using the command:
   ```bash
   mvn spring-boot:run 

# Project Structure
The project is organized into distinct layers for maintainability:

1. Controller: Handles HTTP requests and responses.
2. Service: Contains business logic and interacts with repositories.
3. Repository: Manages data access and interaction with the database.
4. Entity: Defines the data model.


## Frontend
### Setup
Ensure you have Node.js installed, then set up the frontend using:
```bash
npm install
```
## Run the Application
``` 
npm start
```
