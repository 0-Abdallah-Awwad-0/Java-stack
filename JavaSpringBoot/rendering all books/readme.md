# Rendering All Books

## Preview
### All Books Page
![all books page](allbooks.png)

## Run the app
```
# 1. navigate to the project folder
cd Desktop\axsos\Java\spring boot\renderingallbooks

# 2. build and run the Spring Boot app
./mvnw spring-boot:run
```
Then open your browser at: `http://localhost:8080/books`

## Built With
- [Java](https://www.java.com/) — programming language
- [Spring Boot](https://spring.io/projects/spring-boot) — Java web framework
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) — database ORM layer
- [JSP](https://www.oracle.com/java/technologies/jspt.html) — Java Server Pages for HTML templating

## Features
- Display all books in a styled table at `/books`
- View a single book's details by ID at `/books/{id}`
- Create a new book via POST request to `/api/books`
- Update an existing book by ID via PUT request to `/api/books/{id}`
- Delete a book by ID via DELETE request to `/api/books/{id}`
- Automatically track creation and update timestamps on each book