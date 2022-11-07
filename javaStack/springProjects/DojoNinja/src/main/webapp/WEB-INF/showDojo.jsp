<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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
<table class="table">
    <thead>
    <tr>
        <td>
            First Name
        </td>
        <td>
            Last Name
        </td>
        <td>
            Age
        </td>
    </tr>
    </thead>
    <c:forEach var="ninja" items="${dojo.ninjas}">
        <tr class="bg-danger">
            <td>
                <p><c:out value="${ninja.firstName}"></c:out></p>
            </td>
            <td class="bg-danger">
                <p><c:out value="${ninja.lastName}"></c:out></p>
            </td>
            <td class="bg-danger">
                <p><c:out value="${ninja.age}"></c:out></p>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>