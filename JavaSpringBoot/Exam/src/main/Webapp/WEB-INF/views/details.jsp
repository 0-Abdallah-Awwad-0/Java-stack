<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Details</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav>
    <h2>Blog Details</h2>
    <a href="/blogs">Back to Blogs</a>
</nav>
<div class="container">
    <section class="card details-card">
        <h1>${blog.title}</h1>
        <p><strong>Content:</strong></p>
        <p>${getDescription.content}</p>
        <p><strong>Author:</strong></p>
        <a class="creator-link" href="/users/${blog.creator.id}">
                 alt="${blog.creator.firstName}">
            ${blog.creator.firstName} ${blog.creator.lastName}
        </a>

        <c:if test="${blog.creator.id == loggedUserId}">
            <a class="button warning" href="/blogs/${blog.id}/edit">Edit</a>
            <form action="/blogs/${blog.id}" method="post" class="inline-form">
                <input type="hidden" name="_method" value="delete">
                <button class="danger" type="submit" onclick="return confirm('Delete this blog?')">Delete</button>
            </form>
        </c:if>
    </section>
</div>
</body>
</html>
