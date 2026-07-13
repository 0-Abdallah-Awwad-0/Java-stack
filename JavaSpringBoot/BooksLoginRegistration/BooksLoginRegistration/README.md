# Books Login and Registration

This project combines:

- Registration and login
- Model-level validation
- BCrypt password hashing
- Session authentication
- A one-to-many relationship between users and books
- Displaying all books
- Book detail pages
- Creating books
- Owner-only editing and deleting

## Relationship

One user can post many books:

`User 1 -------- many Books`

Every book belongs to one user.

## Book fields

- Title
- Author
- Description / Thoughts
- User who posted it

## Before running

1. Open the project in IntelliJ.
2. Open `src/main/resources/application.properties`.
3. Replace `YOUR_MYSQL_PASSWORD` with your MySQL password.
4. If your root account has no password, use:

   `spring.datasource.password=`

5. Open `pom.xml`.
6. Reload Maven.
7. Run `LoginRegistrationApplication.java`.

The database is created automatically:

`books_login_registration`

## URLs

- Login and registration: `http://localhost:8080/`
- All books: `http://localhost:8080/books`
- Add book: `http://localhost:8080/books/new`
- Book details: `http://localhost:8080/books/{id}`
- Edit book: `http://localhost:8080/books/{id}/edit`
- Logout: `http://localhost:8080/logout`

## Authentication tests

1. Open `/books` without logging in.
2. Confirm that it redirects to `/`.
3. Register a user.
4. Confirm that registration redirects to `/books`.
5. Log out.
6. Try `/books` again.
7. Confirm that it redirects to `/`.

## Book tests

1. Submit an empty book form and confirm all validation messages.
2. Add multiple books.
3. Click a book title and confirm its detail page opens.
4. Create a second user.
5. Confirm that the second user cannot edit or delete the first user's books.
6. Confirm that a user can edit and delete their own books.
