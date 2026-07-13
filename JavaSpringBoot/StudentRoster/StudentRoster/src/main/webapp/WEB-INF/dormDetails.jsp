<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dorm Details</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">

    <header class="page-header">
        <div>
            <h1><c:out value="${dorm.name}"/> Dormitory</h1>
            <p>Manage students assigned to this dorm.</p>
        </div>

        <nav class="actions">
            <a class="button-link"
               href="${pageContext.request.contextPath}/students/new">
                Create Student
            </a>

            <a class="secondary-link"
               href="${pageContext.request.contextPath}/dorms">
                All Dorms
            </a>
        </nav>
    </header>

    <section class="card assignment-section">
        <h2>Add or Reassign a Student</h2>

        <c:choose>
            <c:when test="${empty allStudents}">
                <p>
                    No students exist yet.
                    <a href="${pageContext.request.contextPath}/students/new">
                        Create a student
                    </a>
                    first.
                </p>
            </c:when>

            <c:otherwise>
                <form class="assignment-form"
                      action="${pageContext.request.contextPath}/dorms/${dorm.id}/students"
                      method="post">

                    <div class="field grow">
                        <label for="studentId">Student</label>

                        <select id="studentId"
                                name="studentId"
                                required>

                            <option value="" selected disabled>
                                Select a student
                            </option>

                            <c:forEach var="student" items="${allStudents}">
                                <option value="${student.id}">
                                    <c:out value="${student.firstName}"/>
                                    <c:out value="${student.lastName}"/>

                                    <c:if test="${student.dorm != null}">
                                        — currently in
                                        <c:out value="${student.dorm.name}"/>
                                    </c:if>

                                    <c:if test="${student.dorm == null}">
                                        — unassigned
                                    </c:if>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit">
                        Add / Reassign
                    </button>
                </form>

                <p class="help-text">
                    Selecting a student from another dorm moves that student
                    to <c:out value="${dorm.name}"/>.
                </p>
            </c:otherwise>
        </c:choose>
    </section>

    <section class="card">
        <h2>Residents</h2>

        <c:choose>
            <c:when test="${empty dorm.students}">
                <p>No students are currently assigned to this dorm.</p>
            </c:when>

            <c:otherwise>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th>Student</th>
                            <th>Age</th>
                            <th>Action</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="student" items="${dorm.students}">
                            <tr>
                                <td>
                                    <c:out value="${student.firstName}"/>
                                    <c:out value="${student.lastName}"/>
                                </td>

                                <td>
                                    <c:out value="${student.age}"/>
                                </td>

                                <td>
                                    <form action="${pageContext.request.contextPath}/dorms/${dorm.id}/students/${student.id}/remove"
                                          method="post">

                                        <button class="danger-button"
                                                type="submit">
                                            Remove
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </section>

</main>

</body>
</html>
