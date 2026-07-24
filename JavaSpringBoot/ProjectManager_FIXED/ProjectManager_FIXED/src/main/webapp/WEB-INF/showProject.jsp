<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Details</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">
        <header class="page-header">
            <h1><c:out value="${project.title}"/></h1>
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
        </header>

        <dl class="details">
            <dt>Team Lead</dt>
            <dd>
                <c:out value="${project.lead.firstName}"/>
                <c:out value="${project.lead.lastName}"/>
            </dd>

            <dt>Due Date</dt>
            <dd><c:out value="${project.dueDate}"/></dd>

            <dt>Description</dt>
            <dd class="description">
                <c:out value="${project.description}"/>
            </dd>
        </dl>

        <c:if test="${loggedInUser.id == project.lead.id}">
            <div class="actions">
                <a class="button-link"
                   href="${pageContext.request.contextPath}/projects/${project.id}/edit">
                    Edit Project
                </a>

                <form class="inline-form"
                      action="${pageContext.request.contextPath}/projects/${project.id}"
                      method="post">
                    <input type="hidden" name="_method" value="delete">
                    <button class="danger-button" type="submit">
                        Delete Project
                    </button>
                </form>
            </div>
        </c:if>
    </article>
</main>

</body>
</html>
