# Dating Backend - Project

## Description

This project is the backend for a dating application built using Spring Boot and MongoDB.
This project provides recommendations based on details entered by the user such as gender, age, and interests.

## Technologies Used

- Java : Version 17.0.12
- Spring Boot: Version 3.4.1
- MongoDB Atlas: Version 8.0.4
- Apache Maven : Version 3.9.9 

## Setup Instructions

Follow the steps below to set up and run the project locally:

### 1. Clone the Repository

Clone the repository using the following command:

git clone https://github.com/Kedarnath08/Dating-backend.git


### 2. Navigate to the Project Directory

Change into the project directory using the command:

cd Dating-backend


### 3. Install Dependencies

Ensure you have Maven installed on your machine.To install the required dependencies, run the following command:

mvn clean install


### 4. Run the Application

Once the dependencies are installed, run the application using Maven:

mvn spring-boot:run

The backend will be accessible at http://localhost:8080


### 5. Testing the API with Postman

POST http://localhost:8080/api/users/submit: Add a new user.

{
  "name": "Kedar",
  "age": 25,
  "gender": "Male",
  "interests": ["Boxing", "reading"]
}

GET http://localhost:8080/api/users/recommend/{userId}: Get recommended users.

Example replace {userId} with: 6789657aeddf6c4591466e60


### 6. Testing the Project

Unit tests are already written for key functionalities. To run the tests, use:

mvn test


Project Structure:

- UserController.java:  Handles HTTP requests for user actions.
- UserService.java:  Handles the logic for interacting with the database.
- RecommendationService.java:  Handles the logic for recommending users based on custom rules.
- UserService.java: Contains business logic related to user operations.
- UserRepository.java: Acts as the interface between the application and MongoDB, providing CRUD operations for the UserModel. 
- application.properties:  Contains project configurations (including MongoDB connection details).
