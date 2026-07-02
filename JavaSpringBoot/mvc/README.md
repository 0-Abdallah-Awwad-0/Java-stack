# Book API

## Assignment

This assignment builds a simple Spring Boot MVC API for managing books.

The API allows users to create, view, update, and delete books using HTTP requests.

## Concepts Practiced

* Spring Boot
* MVC structure
* REST API routes
* Controllers
* Models
* Services
* Repositories
* Spring Data JPA
* MySQL database connection
* CRUD operations
* `@Entity`
* `@Id`
* `@GeneratedValue`
* `CrudRepository`
* `@RestController`
* `@RequestMapping`
* `@PathVariable`
* `@RequestParam`

## Project Structure

Book API uses the MVC folder structure:

```text
mvc
└── src
    └── main
        └── java
            └── com
                └── axsosacademy
                    └── mvc
                        ├── controllers
                        │   └── BooksApi.java
                        ├── models
                        │   └── Book.java
                        ├── repositories
                        │   └── BookRepository.java
                        ├── services
                        │   └── BookService.java
                        └── MvcApplication.java
```

## Book Model

The `Book` model represents a book in the database.

### Fields

* `id`
* `title`
* `description`
* `language`
* `pages`

The `id` field is the primary key for each book row in the database.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

## API Routes

### Get All Books

```text
GET /api/books
```

Returns all books from the database.

Example:

```text
http://localhost:8080/api/books
```

---

### Create a Book

```text
POST /api/books
```

Creates a new book.

Required parameters:

* `title`
* `description`
* `language`
* `pages`

Example using curl:

```bash
curl -X POST "http://localhost:8080/api/books" -d "title=Java Basics" -d "description=Intro to Java" -d "language=English" -d "pages=250"
```

---

### Get One Book

```text
GET /api/books/{id}
```

Returns one book by its id.

Example:

```text
http://localhost:8080/api/books/1
```

---

### Update a Book

```text
PUT /api/books/{id}
```

Updates an existing book.

Required parameters:

* `title`
* `description`
* `language`
* `pages`

Example using curl:

```bash
curl -X PUT "http://localhost:8080/api/books/1" -d "title=Java Updated" -d "description=Updated description" -d "language=English" -d "pages=300"
```

The update method finds the existing book first, changes its fields using setter methods, then saves it again.

This prevents creating a duplicate book.

---

### Delete a Book

```text
DELETE /api/books/{id}
```

Deletes a book by its id.

Example using curl:

```bash
curl -X DELETE "http://localhost:8080/api/books/1"
```

## Files

### `Book.java`

Contains the book model and database fields.

It uses:

* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`

---

### `BookRepository.java`

Connects the `Book` model to the database.

It extends:

```java
CrudRepository<Book, Long>
```

This gives access to methods like:

* `findAll()`
* `findById()`
* `save()`
* `deleteById()`

---

### `BookService.java`

Contains the business logic for books.

It includes methods for:

* Getting all books
* Creating a book
* Finding one book
* Updating a book
* Deleting a book

---

### `BooksApi.java`

Contains the API routes.

It handles requests like:

* `GET`
* `POST`
* `PUT`
* `DELETE`

## Database Configuration

The database connection is configured inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/books_schema?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## How to Run

1. Make sure MySQL is running.
2. Open the project in IntelliJ IDEA.
3. Run `MvcApplication.java`.
4. Wait until the console shows:

```text
Tomcat started on port 8080
Started MvcApplication
```

5. Open the browser and test:

```text
http://localhost:8080/api/books
```

At first, it may show:

```json
[]
```

This means the API is working, but there are no books in the database yet.

## Notes

This project practices the full CRUD flow:

Create, Read, Update, and Delete.

The update method uses `save()` after finding the existing book by id.

The delete method uses `deleteById()`.
