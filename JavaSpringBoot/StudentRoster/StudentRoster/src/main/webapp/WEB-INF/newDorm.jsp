<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Dorm</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">

        <header class="page-header">
            <h1>Create a Dorm</h1>

            <a href="${pageContext.request.contextPath}/dorms">
                Back to Dorms
            </a>
        </header>

        <form:form
                action="${pageContext.request.contextPath}/dorms"
                method="post"
                modelAttribute="dorm">

            <div class="field">
                <form:label path="name">Dorm Name</form:label>
                <form:input path="name"/>
                <form:errors path="name" cssClass="error"/>
            </div>

            <button type="submit">Create Dorm</button>
        </form:form>

    </article>
</main>

</body>
</html>
