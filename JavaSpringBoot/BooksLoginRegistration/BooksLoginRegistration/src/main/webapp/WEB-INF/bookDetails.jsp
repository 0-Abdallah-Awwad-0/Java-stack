<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Details</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">
        <header class="page-header">
            <h1><c:out value="${book.title}"/></h1>

            <a href="${pageContext.request.contextPath}/books">
                Back to Books
            </a>
        </header>

        <p>
            <strong>Author:</strong>
            <c:out value="${book.author}"/>
        </p>

        <p>
            <strong>Posted by:</strong>
            <c:out value="${book.user.username}"/>
        </p>

        <section class="description">
            <h2>Description / Thoughts</h2>
            <p><c:out value="${book.description}"/></p>
        </section>

        <c:if test="${loggedInUser.id == book.user.id}">
            <div class="actions">
                <a class="button-link"
                   href="${pageContext.request.contextPath}/books/${book.id}/edit">
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
            </div>
        </c:if>
    </article>
</main>

</body>
</html>
