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
    <title>dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body style="margin: 0 auto; width: 80%; font-family: monospace">
<div>
    <nav>
        <a href="/dashboard">Dashboard</a> |
        <a href="/add/trip">Add a trip</a> |
        <a href="/logout">Logout</a>
    </nav>
    <h1>Welcome <span>${logged.userName }!</span></h1>

    <div>
        <h2><span>All Trips: </span></h2>
        <c:choose>
            <c:when test="${trips.size() == 0 }">
                <p>There are no trips at the moment. Add one!</p>
            </c:when>

            <c:otherwise>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Trip Title</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Participants</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="team" items="${teams}">
                        <tr>
                            <td><a href="/trip/${team.id }">${team.name }</a></td>
                            <td>${team.user.userName}</td>
                                <td>${team.players.size() }/${team.level}</td>
                            <td><a href='/projects/join'>Join Trip</a></td>
                    </c:forEach>

                        </tr>
                    </tbody>
                </table>


            </c:otherwise>
        </c:choose>
        <a href="/add/trip" class="btn btn-success">Add a Trip</a>
    </div>
</div>
</body>
</html>