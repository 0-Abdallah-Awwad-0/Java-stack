<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Projects</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<!-- Navigation bar -->
<nav>
    <h2>ProjectHub</h2>
    <div>
        Welcome, ${loggedUser.firstName} | <a href="/users/${loggedUser.id}">
        My Profile </a> | <a href="/logout"> Logout </a>
    </div>
</nav>
<div class="container two-columns dashboard-grid">
    <!-- Create project section -->
    <section class="card">
        <h2>Create Project</h2>
        <form:form action="/projects" method="post">

            <label>Blog:Blog: Spring Boot Guide</label>
            <label>Add Comment</label>
            <form:textarea path="comment" rows="6"
                           placeholder="Write a comment of the blog" />
            <form:errors path="comment" cssClass="error" />

            <button type="submit">Submit</button>
        </form:form>
    </section>




</div>
</body>
</html>
