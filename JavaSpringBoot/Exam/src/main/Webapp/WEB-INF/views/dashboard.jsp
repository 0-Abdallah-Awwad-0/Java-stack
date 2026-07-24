<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Blogs</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<!-- Navigation bar -->
<nav>
    <div>
        Welcome, ${loggedUser.firstName} |  <a href="/logout"> Logout </a>
    </div>
</nav>
<div class="container two-columns dashboard-grid">
    <!-- Create blog section -->

    <!-- All Blogs section -->
    <section class="card">
        <h2>All Projects</h2>
        <!-- Blogs table -->
        <table>

            <thead>
            <tr>
                <th>Blog Title</th>
                <th>Author</th>
                <th>Created on</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="blog" items="${blogs}">

                <tr>

                    <!-- Blog title -->
                    <td><a href="/blogs/${blog.id}"> ${blog.title}
                    </a></td>


                    <!-- Author -->
                    <td><a class="creator-link"
                           href="/users/${blog.creator.id}">

                             alt="${blog.creator.firstName}">
                    </c:if> ${blog.creator.firstName} ${blog.creator.lastName}

                    </a></td>

                    <!-- Release date -->
                    <td>${blog.releaseDate}</td>

                    <!-- Action buttons -->
                    <td><a class="button" href="/blogs/${blog.id}">
                        Details </a> <!-- Only the creator can edit and delete --> <c:if
                            test="${blog.creator.id == loggedUser.id}">

                        <a class="button warning" href="/blogs/${blog.id}/edit">
                            Edit </a>

                        <form action="/blogs/${blog.id}" method="post"
                              class="inline-form">
                            <input type="hidden" name="_method" value="delete">
                            <button class="danger" type="submit"
                                    onclick="return confirm('Delete this blog?')">
                                Delete</button>
                        </form>
                    </c:if></td>
                </tr>
            </c:forEach>
            <!-- Show message when there are no blogs -->
            <c:if test="${empty blogs}">
                <tr>
                    <td colspan="5">No blogs have been created yet.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>
