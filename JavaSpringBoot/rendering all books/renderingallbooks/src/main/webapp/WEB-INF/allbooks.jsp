<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Books</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="m-0 p-0 min-h-screen bg-[rgb(255,194,119)] flex flex-col justify-center items-center">

<div class="w-[60em] bg-amber-100 border-2 border-[rgb(79,71,71)] rounded-lg shadow-md p-8">
    <h1 class="text-4xl font-bold mb-6 text-[rgb(79,71,71)] [text-shadow:1px_1px_4px_firebrick]">
        All Books
    </h1>

    <table class="w-full border-collapse border border-[rgb(79,71,71)]">
        <thead>
        <tr class="bg-[rgb(255,194,119)]">
            <th class="border border-[rgb(79,71,71)] px-4 py-2 text-left text-[crimson]">ID</th>
            <th class="border border-[rgb(79,71,71)] px-4 py-2 text-left text-[crimson]">Title</th>
            <th class="border border-[rgb(79,71,71)] px-4 py-2 text-left text-[crimson]">Language</th>
            <th class="border border-[rgb(79,71,71)] px-4 py-2 text-left text-[crimson]"># Pages</th>
            <th class="border border-[rgb(79,71,71)] px-4 py-2 text-left text-[crimson]">Reveal the book</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${book}" varStatus="status">
            <tr class="${status.index % 2 == 0 ? 'bg-white' : 'bg-[rgb(255,224,180)]'} hover:bg-orange-100">
                <td class="border border-[rgb(79,71,71)] px-4 py-2">${book.id}</td>
                <td class="border border-[rgb(79,71,71)] px-4 py-2">${book.title}</td>
                <td class="border border-[rgb(79,71,71)] px-4 py-2">${book.language}</td>
                <td class="border border-[rgb(79,71,71)] px-4 py-2">${book.numberOfPages}</td>
                <td class="border border-[rgb(79,71,71)] px-4 py-2 text-[crimson] font-semibold">
                    <a href="/books/${book.id}">Show..</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>