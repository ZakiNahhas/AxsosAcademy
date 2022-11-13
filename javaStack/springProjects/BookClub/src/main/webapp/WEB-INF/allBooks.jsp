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
<body style="margin: 0 auto; width: 80%">
<p style="margin-left: 10px; margin-top: 10px; font-size: 25px">Welcome ${thisUser.userName}</p>
<p><a href="/bookmarket">Go to the Book Market</a></p>
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
        <td>
            Actions
        </td>
    </tr>
    </thead>
<c:forEach var="book" items="${books}">
    <tr class="bg-secondary">
        <td class="bg-secondary">
            <p><c:out value="${book.id}"></c:out></p>
        </td>
        <td class="bg-secondary">

            <p><a style="color: black" href="/books/${book.id}">  <c:out value="${book.title}"></c:out></a></p>
        </td>
        <td class="bg-secondary">
            <p><c:out value="${book.author}"></c:out></p>
        </td>
        <td class="bg-secondary">
            <p><c:out value="${book.user.userName}"></c:out></p>
        </td>
       <td>
           <c:if test="${user_id == book.user.id}">
               <div style="display: flex;">
                   <form action="/books/${book.id}" method="post">
                       <input type="hidden" name="_method" value="delete">
                       <input class="btn btn-danger" type="submit" value="Delete">
                   </form>
                   <div style="margin-left: 20px; color: wheat;"><a class="btn btn-success" href="/books/${book.id}/edit">Edit</a>
                   </div>
               </div>
           </c:if>
       </td>
    </tr>
</c:forEach>
</table>

</body>
</html>