<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Students</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">

    <header class="page-header">
        <div>
            <h1>All Students</h1>
            <p>Students may be assigned or unassigned.</p>
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

    <section class="card">
        <c:choose>
            <c:when test="${empty students}">
                <p>No students have been created yet.</p>
            </c:when>

            <c:otherwise>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Dorm</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>
                                    <c:out value="${student.firstName}"/>
                                    <c:out value="${student.lastName}"/>
                                </td>

                                <td>
                                    <c:out value="${student.age}"/>
                                </td>

                                <td>
                                    <c:choose>
                                        <c:when test="${student.dorm != null}">
                                            <a href="${pageContext.request.contextPath}/dorms/${student.dorm.id}">
                                                <c:out value="${student.dorm.name}"/>
                                            </a>
                                        </c:when>

                                        <c:otherwise>
                                            <span class="muted">Unassigned</span>
                                        </c:otherwise>
                                    </c:choose>
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
