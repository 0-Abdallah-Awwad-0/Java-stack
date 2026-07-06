<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Books rendering</title>
</head>
<body class="m-0 p-0 flex flex-col justify-center items-center min-h-screen bg-[rgb(255,194,119)]">

<div>
    <h1 class="text-6xl text-[rgb(79,71,71)] [text-shadow:1px_1px_4px_firebrick]">
        ${book.title}
    </h1>
    <h2 class="text-3xl text-[crimson] [text-shadow:1px_1px_4px_rgb(79,71,71)]">
        description : ${book.description}
    </h2>
    <h2 class="text-3xl text-[crimson] [text-shadow:1px_1px_4px_rgb(79,71,71)]">
        language : ${book.language}
    </h2>
    <h2 class="text-3xl text-[crimson] [text-shadow:1px_1px_4px_rgb(79,71,71)]">
        number of pages : ${book.numberOfPages}
    </h2>
</div>

</body>
</html>