<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>


</head>
<body>
<p style="margin-left: 10px; margin-top: 10px; font-size: 25px">Welcome ${thisUser.userName}</p>
<p style="margin-left: 10px; margin-top: 10px; font-size: 25px">Books from everyone's shelves: </p>
<p style="text-align: right; margin-right: 10px; font-size: 25px"><a href="/logout">logout</a></p>
<p style="text-align: right; margin-right: 10px; font-size: 25px"><a href="/books/new">Add a book to my shelf!</a></p>
<table class="table">
    <thead>
    <tr>
        <td>
            ID
        </td>
        <td>
            Title
        </td>
        <td>
            Author Name
        </td>
        <td>
            Posted By
        </td>
    </tr>
    </thead>
<c:forEach var="book" items="${books}">
    <tr class="bg-danger">
        <td class="bg-danger">
            <p><c:out value="${book.id}"></c:out></p>
        </td>
        <td class="bg-danger">

            <p><a href="/books/${book.id}">  <c:out value="${book.title}"></c:out></a></p>
        </td>
        <td class="bg-danger">
            <p><c:out value="${book.authorName}"></c:out></p>
        </td>
        <td class="bg-danger">
            <p><c:out value="${book.postedBy}"></c:out></p>

            <form action="/books/${book.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input class="bg-secondary" type="submit" value="Delete">
            </form>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>