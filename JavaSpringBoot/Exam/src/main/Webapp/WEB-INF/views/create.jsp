<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 7/14/2026
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="card">
<h2>Create Project</h2>
<form:form action="/blogs" method="post"
           modelAttribute="newBlog">
    <!-- Project title -->
    <label>Title</label>
    <form:input path="title" placeholder="Enter project title" />
    <form:errors path="title" cssClass="error" />
    <label>Category</label>
        <form:input path="title" placeholder="Enter the category" />
        <form:errors path="category" cssClass="error" />
    <!--Blog content -->
    <label>Content</label>
        <form:textarea path="content" rows="6"
                       placeholder="Write a content" />
        <form:errors path="content" cssClass="error" />

    <button type="submit">Save</button>
    </form:form>

</body>
</html>
