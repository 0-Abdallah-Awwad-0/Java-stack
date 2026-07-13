<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add a Book</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">
        <header class="page-header">
            <h1>Add a Book</h1>

            <a href="${pageContext.request.contextPath}/books">
                Back to Books
            </a>
        </header>

        <form:form
                action="${pageContext.request.contextPath}/books"
                method="post"
                modelAttribute="book">

            <div class="field">
                <form:label path="title">Title</form:label>
                <form:input path="title"/>
                <form:errors path="title" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="author">Author</form:label>
                <form:input path="author"/>
                <form:errors path="author" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="description">
                    Description / Thoughts
                </form:label>
                <form:textarea path="description" rows="7"/>
                <form:errors path="description" cssClass="error"/>
            </div>

            <button type="submit">Create Book</button>
        </form:form>
    </article>
</main>

</body>
</html>
