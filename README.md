# Library Management System APIs App Built By Spring Boot
## This is an assessment Deliver for Maids.cc Built by Assem Salama Aug 8th 2024

*Description*   
This is a Spring Boot App that provides specific endpoints for Library Management System. This app provides the following endpoints functionalites as required in the assessment.  
1. Get All Books, by Id, update and delete a book.
2. Get All Patrons, by Id, update and delete a patron.
3. Borrowind Endpoints allow patron to borrow a book and return it.

*How to Start*
1. Clone the repository to your favorite code editor.
2. Make sure java SDK are correctly installed in your machine.
3. You can run the app from the run button or type ./mvnw spring-boot:run in the terminal.
4. Random Data will be generated once starting the app
5. Make your own edits in application.properties file  
spring.application.name=Library Management System
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true


*Lets rock into the APIs*
### Books
1. To Get all books: GET http://localhost:8080/api/books
2. To get a book by id:GET http://localhost:8080/api/books/id-here
3. To Add new book: POST http://localhost:8080/api/books and add the request body as {
    "author": "Assem",
    "publicationYear": "1948",
    "isbn": "135566733X"
}
4. To update a book: PUT http://localhost:8080/api/books/id-here and add your request body as {
    "author": "Assem",
    "publicationYear": "1948",
    "isbn": "135566733X"
}
5. To delete a book: DELETE http://localhost:8080/api/books/id-here

###Patrons
1. To Get all Patrons: GET http://localhost:8080/api/patrons
2. To get a Patron by id: GET http://localhost:8080/api/patrons/id-here
3. To add new Patron: POST http://localhost:8080/api/patrons and add the request body as {
        "name": "Assem Salama",
        "contactInfo": "911-950-7368 x439"
}
4. To Update a Patron: PUT http://localhost:8080/api/patrons/id-here and add the request body as {
        "name": "Assem Lamy",
        "contactInfo": "911-950-7368 x439"
}
5. To delete a Patron: DELETE http://localhost:8080/api/patrons/id-here

### Borrowing Records
Borrowing records only have 2 endpoints, the first one is to post a borrow time and the second one to add the return time by PUT method. Here is how
1. Borrowing a book: POST http://localhost:8080/api/borrow/1/patron/5 , You will get the response as shown here
with return date null.
![image](https://github.com/user-attachments/assets/ae563e91-e2c3-4eea-811d-22e42d4851e9)
2. when the patron returns the books we use: PUT http://localhost:8080/api/return/1/patron/5. this will assing the return date as the current time which the patron returned the book at
![image](https://github.com/user-attachments/assets/2300708e-6cc2-4979-8439-f5faade0f9d6)

The @Transactional annotation is used in the previous 2 methods (Borrow and Return) to mark methods or classes that should be executed within a transaction context. This means that Spring will automatically handle the transaction boundaries beginning, committing, or rolling back the transaction based on the execution of the annotated method.

### Authorization
To be implemented
