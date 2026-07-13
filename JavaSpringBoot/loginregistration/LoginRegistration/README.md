# Login and Registration

Spring Boot assignment with:

- User registration
- Model-level validation
- Unique email validation
- Password confirmation validation
- BCrypt password hashing
- Login authentication
- Session-based access protection
- Logout

## Project package

`com.axsos.loginregistration`

## Before running

1. Open `src/main/resources/application.properties`.
2. Replace `YOUR_MYSQL_PASSWORD` with your MySQL password.
3. If your MySQL root account has no password, leave the value empty:

   `spring.datasource.password=`

4. Reload Maven in IntelliJ.
5. Run `LoginRegistrationApplication.java`.

The database is created automatically because the URL contains:

`createDatabaseIfNotExist=true`

## Test URLs

- Main registration/login page: `http://localhost:8080/`
- Protected success page: `http://localhost:8080/success`
- Logout: `http://localhost:8080/logout`

## Validation tests

Registration:

- Leave every field blank.
- Enter a username shorter than 3 characters.
- Enter numbers or symbols in the username.
- Enter an invalid email.
- Enter a password shorter than 8 characters.
- Enter two different passwords.
- Register the same email twice.
- Correct errors on a second and third submission.

Login:

- Enter an email that is not registered.
- Enter the wrong password.
- Enter the correct email and password.

Session/logout:

- Log in and open `/success`.
- Click Logout.
- Manually open `/success` again.
- Confirm that you are redirected to `/`.
