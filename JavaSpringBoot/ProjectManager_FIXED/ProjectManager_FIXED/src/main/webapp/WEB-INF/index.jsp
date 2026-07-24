<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Manager</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">
    <header class="center-heading">
        <h1>Project Manager</h1>
        <p>Register or log in to manage projects.</p>
    </header>

    <section class="two-columns">
        <article class="card">
            <h2>Register</h2>

            <form:form action="${pageContext.request.contextPath}/register"
                       method="post"
                       modelAttribute="newUser">

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
                    <form:label path="email">Email</form:label>
                    <form:input path="email" type="email"/>
                    <form:errors path="email" cssClass="error"/>
                </div>

                <div class="field">
                    <form:label path="password">Password</form:label>
                    <form:password path="password"/>
                    <form:errors path="password" cssClass="error"/>
                </div>

                <div class="field">
                    <form:label path="confirm">Confirm Password</form:label>
                    <form:password path="confirm"/>
                    <form:errors path="confirm" cssClass="error"/>
                </div>

                <button type="submit">Register</button>
            </form:form>
        </article>

        <article class="card">
            <h2>Login</h2>

            <form:form action="${pageContext.request.contextPath}/login"
                       method="post"
                       modelAttribute="newLogin">

                <div class="field">
                    <form:label path="email">Email</form:label>
                    <form:input path="email" type="email"/>
                    <form:errors path="email" cssClass="error"/>
                </div>

                <div class="field">
                    <form:label path="password">Password</form:label>
                    <form:password path="password"/>
                    <form:errors path="password" cssClass="error"/>
                </div>

                <button type="submit">Login</button>
            </form:form>
        </article>
    </section>
</main>

</body>
</html>
