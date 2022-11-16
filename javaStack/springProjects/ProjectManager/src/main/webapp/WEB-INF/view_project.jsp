<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Project Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Project Details</h1>
<a href="/dashboard">Back To Dashboard</a>

<h3>Project: ${projectDet.title}</h3>
<h3>Description: ${projectDet.description}</h3>
<h3>Due Date: <fmt:formatDate value="${projectDet.duedate}" pattern ="MMMM-dd-yyyy"/></h3>
<c:choose>
    <c:when test="${projectDet.projectLeader.id==currentUserId}">
        <form action="/projects/${projectDet.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete Project">
        </form>
    </c:when>
</c:choose>

</body>
</html>