<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Project</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">
        <header class="page-header">
            <h1>Create a Project</h1>
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
        </header>

        <form:form action="${pageContext.request.contextPath}/projects"
                   method="post"
                   modelAttribute="project">

            <div class="field">
                <form:label path="title">Project Title</form:label>
                <form:input path="title"/>
                <form:errors path="title" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="description">Description</form:label>
                <form:textarea path="description" rows="7"/>
                <form:errors path="description" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="dueDate">Due Date</form:label>
                <form:input path="dueDate" type="date"/>
                <form:errors path="dueDate" cssClass="error"/>
            </div>

            <button type="submit">Create Project</button>
        </form:form>
    </article>
</main>

</body>
</html>
