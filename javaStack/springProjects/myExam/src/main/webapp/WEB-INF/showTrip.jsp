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
<body style="font-family: monospace; width: 80%; margin: 0 auto; background-color: #b1bac4; color: black">

<div>
    <nav>

    </nav>
    <a href="/dashboard">Dashboard</a>
    <br> <br>
    <h1>${trip.title }</h1>
    <br>
    <br>
    <p>Created by: ${trip.user.userName }</p>
    <p>Participants: ${trip.capacity }</p>
    <p>Details: ${trip.details }</p>
    <hr>
    <hr>
    <br>
    <c:choose>
        <c:when test="${trip.user.id==user_id}">
            <a class="btn btn-success" href="/edit/trip/${trip.id }">Edit Trip</a> <br>
            <br>
            <a class="btn btn-danger" href="/delete/trip/${trip.id}">Delete Trip</a>
            <br>
        </c:when>
    </c:choose>
    <br>
    <div style="display: flex;">


        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Name</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <c:forEach var="player" items="${trip.players}">
                <td>${player.userName}</td>
<%--                <c:if test="${trip.user.id == user_id}">--%>
<%--                    <c:if test="${trip.user.id != player.id}">--%>
<%--                        <td>--%>
<%--                                &lt;%&ndash;@elvariable id="join" type="join"&ndash;%&gt;--%>
<%--                            <form:form method="post" action="/remove/${trip.id}" modelAttribute="join">--%>
<%--                                <input type="hidden" name=trip value="${ trip.id}"/>--%>
<%--                                <input type="hidden" name=user value="${ player.id}"/>--%>
<%--                                <input type="submit" value="Remove">--%>
<%--                            </form:form>--%>
<%--                        </td>--%>
<%--                    </c:if>--%>
<%--                </c:if>--%>
            </tr>

            </c:forEach>
            </tbody>
        </table>


        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Join Date</th>
            </tr>
            </thead>
            <tbody>
            <tr>

                <c:forEach var="date" items="${joinDate}">
                <c:if test="${date == null}">
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${trip.createdAt}"/></td>
                </c:if>
                <c:if test="${date != null}">
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${date}"/></td>

                </c:if>

            </tr>

            </c:forEach>
            </tbody>
        </table>

        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr><td></td></tr>
            <tr>
                <c:forEach var="player" items="${trip.players}">
<%--                <td>${player.userName}</td>--%>
                <c:if test="${trip.user.id == user_id}">
                    <c:if test="${trip.user.id != player.id}">
                        <td style="height: 25%;">
                                <%--@elvariable id="join" type="join"--%>
                            <form:form method="post" action="/remove/${trip.id}" modelAttribute="join">
                                <input type="hidden" name=trip value="${ trip.id}"/>
                                <input type="hidden" name=user value="${ player.id}"/>
                                <input type="submit" value="Remove">
                            </form:form>
                        </td>
                    </c:if>
                </c:if>
            </tr>

            </c:forEach>
            </tbody>
        </table>


    </div>

</div>
</div>
</div>

</body>
</html>