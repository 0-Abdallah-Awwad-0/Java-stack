<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Student</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="form-page">
    <article class="card">

        <header class="page-header">
            <h1>Create a Student</h1>

            <a href="${pageContext.request.contextPath}/dorms">
                Back to Dorms
            </a>
        </header>

        <form:form
                action="${pageContext.request.contextPath}/students"
                method="post"
                modelAttribute="student">

            <form:errors path="*" cssClass="error general-error"/>

            <div class="field">
                <form:label path="firstName">First Name</form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="lastName">Last Name</form:label>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>

            <div class="field">
                <form:label path="age">Age</form:label>
                <form:input path="age" type="number"/>
                <form:errors path="age" cssClass="error"/>
            </div>

            <div class="field">
                <label for="dormId">Dorm</label>

                <select id="dormId" name="dormId">
                    <option value="">Unassigned</option>

                    <c:forEach var="dorm" items="${dorms}">
                        <option value="${dorm.id}">
                            <c:out value="${dorm.name}"/>
                        </option>
                    </c:forEach>
                </select>

                <c:if test="${empty dorms}">
                    <small>
                        No dorms exist yet. The student will remain unassigned.
                    </small>
                </c:if>
            </div>

            <button type="submit">Create Student</button>
        </form:form>

    </article>
</main>

</body>
</html>
