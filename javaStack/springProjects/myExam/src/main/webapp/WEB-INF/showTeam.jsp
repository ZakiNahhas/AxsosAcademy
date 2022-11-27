<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body style="font-family: monospace; width: 80%; margin: 0 auto">

<div>
    <nav>

    </nav>
    <a href="/dashboard">Dashboard</a>
    <br>
    <h1>${team.name }</h1>
    <br>
    <br>
    <p>Created by: ${team.user.userName }</p>
    <p>Participants: ${team.level }</p>
    <p>Details: ${team.day }</p>
    <br>
    <ul>
        <c:forEach var="user" items="${assignedUsers}">
            <li><c:out value="${user.userName}"></c:out></li>
        </c:forEach>
    </ul>
    <br>
    <hr>
    <hr>
    <br>
    <c:choose>
        <c:when test="${team.user.id==user_id}">
            <a class="btn btn-success" href="/edit/trip/${team.id }">Edit Trip</a> <br>
            <br>
            <a class="btn btn-danger" href="/delete/trip/${team.id}">Delete Trip</a>
            <br>
        </c:when>
    </c:choose>
</div>
</div>


</div>
</body>
</html>