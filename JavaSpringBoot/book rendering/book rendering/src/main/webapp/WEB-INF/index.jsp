<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/style.css">
    <title>Books rendering </title>
</head>
<body>
    <div>
        <h1> ${book.title} </h1>
        <h2>description : ${book.description} </h2>
        <h2>language : ${book.language}</h2>
        <h2>number of pages : ${book.numberOfPages}</h2>
    </div>
</body>
</html>