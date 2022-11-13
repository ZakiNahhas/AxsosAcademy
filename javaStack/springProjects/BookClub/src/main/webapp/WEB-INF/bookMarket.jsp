<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Market</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>


</head>
<body style="margin: 0 auto; width: 80%">

<p style="color: darkmagenta">Hello <c:out value="${user.userName}"></c:out>. Welcome to</p>
<a href="/books">Back to shelves</a>
<p>Available books to borrow</p>
<hr>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Title</td>
        <td>Author Name</td>
        <td>Owner</td>
        <td>Actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr class="bg-secondary">
            <td class="bg-secondary"><c:out value="${book.id}"></c:out></td>
            <td class="bg-secondary"><a style="color: black" href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
            <td class="bg-secondary"><c:out value="${book.author}"></c:out></td>
            <td class="bg-secondary"><c:out value="${book.user.userName}"></c:out></td>
            <c:if test="${book.user.id==user.id}">
                <td><a class="btn btn-success" href="/books/${book.id}/edit">Edit</a> <a class="btn btn-danger" href="/bookmarketDel/${book.id}">Delete</a></td>
            </c:if>
            <c:if test="${book.user.id!=user.id}">
                <td><a class="btn btn-primary" href="/bookmarket/${book.id}">Borrow</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>Books I'm borrowing..</p>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Title</td>
        <td>Author Name</td>
        <td>Owner</td>
        <td>Actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${myBooks}">
        <tr>
            <td><c:out value="${book.id}"></c:out></td>
            <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
            <td><c:out value="${book.author}"></c:out></td>
            <td><c:out value="${book.user.userName}"></c:out></td>
            <td><a class="btn btn-danger" href="/bookmarket/return/${book.id}">return</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>