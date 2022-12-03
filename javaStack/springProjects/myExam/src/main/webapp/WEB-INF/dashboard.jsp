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
<body style="margin: 0 auto; width: 80%; font-family: monospace; background-color: #b1bac4; color: black">
<div>
    <nav>
        <a href="/dashboard">Dashboard</a> |
        <a href="/add/trip">Add a trip</a> |
        <a href="/logout">Logout</a>
    </nav>
    <br>
    <h1>Welcome,<span> <i> ${logged.userName }!</i></span></h1>
    <br>
    <div>
        <h2><span>All Trips: </span></h2>
        <c:choose>
            <c:when test="${trips.size() == 0 }">
                <p>There are no trips at the moment. Be the first to add one!</p>
            </c:when>

            <c:otherwise>
                <table class="table table-striped table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Trip Title</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Participants</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="trip" items="${trips}">
                    <tr>
                        <td><a href="/trip/${trip.id }">${trip.title }</a></td>
                        <c:choose>
                        <c:when test="${trip.user.id==logged.id}">
                            <td>You!</td>
                        </c:when>
                            <c:otherwise>
                            <td>${trip.user.userName}</td>
                            </c:otherwise>
                        </c:choose>

                        <c:if test="${trip.players.size()>=trip.capacity}">
                            <td>Trip is full</td>
                        </c:if>
                        <c:if test="${trip.players.size()<trip.capacity}">
                            <td>${trip.players.size() }/${trip.capacity}</td>
                        </c:if>

                        <c:choose>
                            <c:when test="${trip.players.contains(logged) || trip.user.id==logged.id}">
                                <td>Already joined!</td>
                            </c:when>
                            <c:when test="${trip.players.size()>=trip.capacity}">
                                <td>Trip is full!</td>
                            </c:when>
                            <c:otherwise>
                                <td> <%--@elvariable id="join" type="join"--%>
                                    <form:form method="post" action="/trips/join"  modelAttribute="join" >
                                        <input type="hidden" name=trip value="${ trip.id}" />
                                        <input type="hidden" name=user value="${ logged.id}" />
                                        <input type="submit" value="join trip">
                                    </form:form></td>
                            </c:otherwise>
                        </c:choose>

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