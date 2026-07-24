<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">
    <header class="page-header">
        <div>
            <h1>Welcome, <c:out value="${loggedInUser.firstName}"/>!</h1>
            <p>Manage your projects.</p>
        </div>

        <nav class="actions">
            <a class="button-link"
               href="${pageContext.request.contextPath}/projects/new">
                New Project
            </a>

            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </header>

    <section class="card">
        <h2>All Projects</h2>
        <p class="muted">Projects created by other users.</p>

        <c:choose>
            <c:when test="${empty otherProjects}">
                <p>No projects from other users yet.</p>
            </c:when>

            <c:otherwise>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th>Project</th>
                            <th>Team Lead</th>
                            <th>Due Date</th>
                            <th>Action</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="project" items="${otherProjects}">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/projects/${project.id}">
                                        <c:out value="${project.title}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${project.lead.firstName}"/>
                                    <c:out value="${project.lead.lastName}"/>
                                </td>
                                <td><c:out value="${project.dueDate}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/projects/${project.id}">
                                        View
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </section>

    <section class="card">
        <h2>My Projects</h2>

        <c:choose>
            <c:when test="${empty myProjects}">
                <p>You have not created any projects yet.</p>
            </c:when>

            <c:otherwise>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th>Project</th>
                            <th>Due Date</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="project" items="${myProjects}">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/projects/${project.id}">
                                        <c:out value="${project.title}"/>
                                    </a>
                                </td>
                                <td><c:out value="${project.dueDate}"/></td>
                                <td class="actions-cell">
                                    <a href="${pageContext.request.contextPath}/projects/${project.id}">
                                        View
                                    </a>

                                    <a href="${pageContext.request.contextPath}/projects/${project.id}/edit">
                                        Edit
                                    </a>

                                    <form class="inline-form"
                                          action="${pageContext.request.contextPath}/projects/${project.id}"
                                          method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <button class="danger-button" type="submit">
                                            Delete
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
