<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Dorms</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">

    <header class="page-header">
        <div>
            <h1>Student Roster</h1>
            <p>View dormitories and their students.</p>
        </div>

        <nav class="actions">
            <a class="button-link"
               href="${pageContext.request.contextPath}/dorms/new">
                Create Dorm
            </a>

            <a class="button-link"
               href="${pageContext.request.contextPath}/students/new">
                Create Student
            </a>

            <a class="secondary-link"
               href="${pageContext.request.contextPath}/students">
                All Students
            </a>
        </nav>
    </header>

    <section class="card">
        <h2>All Dorms</h2>

        <c:choose>
            <c:when test="${empty dorms}">
                <p>No dorms have been created yet.</p>
            </c:when>

            <c:otherwise>
                <div class="dorm-grid">
                    <c:forEach var="dorm" items="${dorms}">
                        <article class="dorm-card">
                            <h3>
                                <a href="${pageContext.request.contextPath}/dorms/${dorm.id}">
                                    <c:out value="${dorm.name}"/>
                                </a>
                            </h3>

                            <p>
                                Students:
                                <strong>
                                    <c:out value="${dorm.students.size()}"/>
                                </strong>
                            </p>
                        </article>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </section>

</main>

</body>
</html>
