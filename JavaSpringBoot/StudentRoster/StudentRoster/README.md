# Student Roster

A Spring Boot one-to-many relationship assignment.

## Features

- View all dorms
- Create dorms
- View a dorm and its residents
- Create students
- Assign a student to a dorm
- Remove a student from a dorm
- Reassign a student from one dorm to another
- Display each student's current dorm in the reassignment dropdown

## Relationship

One dorm can contain many students.

Each student can belong to one dorm.

A student may also temporarily remain unassigned.

```text
Dorm 1 ---------------- many Students
```

## Models

### Dorm

- `id`
- `name`
- `students`
- `createdAt`
- `updatedAt`

### Student

- `id`
- `firstName`
- `lastName`
- `age`
- `dorm`
- `createdAt`
- `updatedAt`

## Before Running

1. Open the project folder in IntelliJ.
2. Open `src/main/resources/application.properties`.
3. Replace `YOUR_MYSQL_PASSWORD` with your MySQL password.
4. If the MySQL root user has no password, use:

   `spring.datasource.password=`

5. Open `pom.xml`.
6. Click Maven Reload.
7. Run `StudentRosterApplication.java`.

The application creates this database automatically:

`student_roster`

## URLs

- All dorms: `http://localhost:8080/dorms`
- Create dorm: `http://localhost:8080/dorms/new`
- Dorm details: `http://localhost:8080/dorms/{id}`
- Create student: `http://localhost:8080/students/new`
- All students: `http://localhost:8080/students`

## Suggested Test Order

1. Create two dorms.
2. Create three students.
3. Assign students to different dorms.
4. Open a dorm detail page.
5. Reassign a student from the other dorm.
6. Confirm the student's old dorm no longer lists them.
7. Remove a student and confirm they appear as unassigned.
8. Test blank and invalid forms several times to confirm validation messages remain visible.
