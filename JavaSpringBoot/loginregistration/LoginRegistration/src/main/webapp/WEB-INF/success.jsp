<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="success-card">
    <h1>Welcome, <c:out value="${user.username}"/>!</h1>

    <p>You successfully logged in.</p>

    <a class="logout"
       href="${pageContext.request.contextPath}/logout">
        Logout
    </a>
</main>

</body>
</html>
