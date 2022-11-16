<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="ISO-8859-1">
    <title>Main Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Welcome, <span>${currentUser.userName}</span></h1>
<h2>All Projects:</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Project</th>
        <th scope="col">Team Lead</th>
        <th scope="col">Due Date</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="notProjectLeader" items="${notProjectLeader}">
        <tr>
            <td><a href="/projects/${notProjectLeader.id}">${notProjectLeader.title}</a></td>
            <td>${notProjectLeader.projectLeader.userName}</td>
            <td><fmt:formatDate value="${notProjectLeader.duedate}" pattern ="MMMM-dd-yyyy"/></td>
            <td><a href='/projects/${notProjectLeader.id}/join'>Join Team</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Project</th>
        <th scope="col">Team Lead</th>
        <th scope="col">Due Date</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="projectLeader" items="${projectLeader}">
    <tr>
        <td><a href="/projects/${projectLeader.id}">${projectLeader.title}</a></td>
        <td>${projectLeader.projectLeader.userName}</td>
        <td> <fmt:formatDate value="${projectLeader.duedate}" pattern ="MMMM-dd-yyyy"/></td>
        <c:choose>
            <c:when test="${projectLeader.projectLeader.id==currentUser.id}">
                <td><a href='/projects/${projectLeader.id}/edit'>edit</a></td>
            </c:when>
            <c:otherwise>
                <td><a href='/projects/${projectLeader.id}/leave'>Leave Team</a></td>
            </c:otherwise>
        </c:choose>
        </td>
    </tr>
    </c:forEach>
</table>
<a href="/logout">Log Out</a>
<a href="/projects/new">Add New Project</a>
</body>
</html>