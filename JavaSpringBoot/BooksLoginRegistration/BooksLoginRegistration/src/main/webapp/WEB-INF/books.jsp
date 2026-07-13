<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">

    <header class="page-header">
        <div>
            <h1>Welcome, <c:out value="${loggedInUser.username}"/>!</h1>
            <p>Books from everyone's shelves</p>
        </div>

        <nav class="actions">
            <a class="button-link"
               href="${pageContext.request.contextPath}/books/new">
                Add a Book
            </a>

            <a class="secondary-link"
               href="${pageContext.request.contextPath}/logout">
                Logout
            </a>
        </nav>
    </header>

    <section class="card">
        <h2>All Books</h2>

        <c:choose>
            <c:when test="${empty books}">
                <p>No books have been added yet.</p>
            </c:when>

            <c:otherwise>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Posted By</th>
                            <th>Actions</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/books/${book.id}">
                                        <c:out value="${book.title}"/>
                                    </a>
                                </td>

                                <td>
                                    <c:out value="${book.author}"/>
                                </td>

                                <td>
                                    <c:out value="${book.user.username}"/>
                                </td>

                                <td>
                                    <c:if test="${loggedInUser.id == book.user.id}">
                                        <a href="${pageContext.request.contextPath}/books/${book.id}/edit">
                                            Edit
                                        </a>

                                        <form class="inline-form"
                                              action="${pageContext.request.contextPath}/books/${book.id}"
                                              method="post">

                                            <input type="hidden"
                                                   name="_method"
                                                   value="delete">

                                            <button class="danger-button"
                                                    type="submit">
                                                Delete
                                            </button>
                                        </form>
                                    </c:if>
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
