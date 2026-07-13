<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Registration</title>
    <link rel="stylesheet"
          href="<c:url value='/css/style.css'/>">
</head>
<body>

<main class="container">
    <h1>Book Club</h1>

    <section class="forms">

        <article class="card">
            <h2>Register</h2>

            <form:form
                    action="${pageContext.request.contextPath}/register"
                    method="post"
                    modelAttribute="newUser">

                <div class="field">
                    <form:label path="username">Username</form:label>
                    <form:input path="username"/>
                    <form:errors path="username" cssClass="error"/>
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
                    <form:label path="confirm">
                        Confirm Password
                    </form:label>
                    <form:password path="confirm"/>
                    <form:errors path="confirm" cssClass="error"/>
                </div>

                <button type="submit">Register</button>
            </form:form>
        </article>

        <article class="card">
            <h2>Login</h2>

            <form:form
                    action="${pageContext.request.contextPath}/login"
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
