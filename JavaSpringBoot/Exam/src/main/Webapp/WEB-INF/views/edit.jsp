<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Project</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav>
    <h2>Edit Project</h2>
    <a href="/blogs/${blog.id}">Cancel</a>
</nav>
<div class="container narrow">
    <section class="card">
        <form:form action="/blogs/${blog.id}" method="post"
                   modelAttribute="blog">


            <label>Title</label>
            <form:input path="title" />
            <form:errors path="title" cssClass="error" />

            <label>Category</label>
            <form:input path="title" />
            <form:errors path="title" cssClass="error" />




            <label>Content</label>
            <form:textarea path="content" rows="7" />
            <form:errors path="content" cssClass="error" />

            <button type="submit">Save Changes</button>
        </form:form>
    </section>
</div>
</body>
</html>
