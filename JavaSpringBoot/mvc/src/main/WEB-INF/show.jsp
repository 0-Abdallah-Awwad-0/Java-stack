<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Details</title>
</head>
<body>

<h1>Book Details</h1>

<p><strong>Title:</strong> ${book.title}</p>
<p><strong>Description:</strong> ${book.description}</p>
<p><strong>Language:</strong> ${book.language}</p>
<p><strong>Pages:</strong> ${book.pages}</p>

</body>
</html>