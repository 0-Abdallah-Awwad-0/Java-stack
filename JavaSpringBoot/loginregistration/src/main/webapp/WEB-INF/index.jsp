<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login and Registration</title>
</head>
<body>

<h1>Login and Registration</h1>

<h2>Register</h2>

<form:form action="/register" method="post" modelAttribute="newUser">

    <p>
        <form:label path="username">Username:</form:label>
        <form:input path="username" />
        <form:errors path="username" />
    </p>

    <p>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
        <form:errors path="email" />
    </p>

    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password" />
        <form:errors path="password" />
    </p>

    <p>
        <form:label path="confirmPassword">Confirm Password:</form:label>
        <form:password path="confirmPassword" />
        <form:errors path="confirmPassword" />
    </p>

    <button type="submit">Register</button>

</form:form>

<hr>

<h2>Login</h2>

<form:form action="/login" method="post" modelAttribute="newLogin">

    <p>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
        <form:errors path="email" />
    </p>

    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password" />
        <form:errors path="password" />
    </p>

    <button type="submit">Login</button>

</form:form>

</body>
</html>