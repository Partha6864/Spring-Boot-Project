# Spring Boot CRUD Application
This project is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot,designed to manage students,subjects and their enrollments.It demonstrates the use of core Spring Boot features,RESTful web services and JPA(Java Persistence API) for database interactions.

## Features
- **Student Management:** Add,retrieve,update and delete student details.
- **Subject Management:** Add,retrieve,update and delete subject details.
- **Enrollment Management:** Enroll students in subjects and manage their enrollments.

## Technologies Used
- **Spring Boot 3.3.2:** Simplifies the development of Java applications.
- **Java 21:** The programming language used for the application.
- **Spring Data JPA:** For database operations.
- **Hibernate:** ORM framework for data persistence.
- **MySQL:** The database used for storing application data.
- **Lombok:** To reduce boilerplate code.

## Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/spring-boot-crud-application.git
    cd spring-boot-crud-application
    ```

2. **Configure the Database**:
    - Ensure you have MySQL installed and running.
    - Create a MySQL database named `student_management`.
    - Update the `application.properties` file with your database credentials.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/student_management
    spring.datasource.username=root
    spring.datasource.password=Partha@6864
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build the Project**:
    - Make sure you have Maven installed. You can check by running:
        ```bash
        mvn -version
        ```
    - Navigate to the project directory and build the project using Maven:
        ```bash
        ./mvnw clean install
        ```

4. **Run the Application**:
    - After building the project, you can run the application using Maven:
        ```bash
        ./mvnw spring-boot:run
        ```
    - Alternatively, you can run the application by executing the generated JAR file:
        ```bash
        java -jar target/spring-boot-crud-application-0.0.1-SNAPSHOT.jar
        ```

5. **Access the Application**:
    - The application will run on [http://localhost:8080](http://localhost:8080).

## Testing the Application

- **Using Postman**:
    - Import the provided Postman collection (if available) or manually create requests to test the various API endpoints.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements
Special thanks to the Spring Boot community for their excellent documentation and support.
