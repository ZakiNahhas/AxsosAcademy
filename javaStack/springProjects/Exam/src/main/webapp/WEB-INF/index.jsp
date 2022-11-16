<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
</head>
<body style="margin: 0 auto; width: 50%">
<br>
<%--@elvariable id="newUser" type=""--%>
<form:form action="/register" method="post" modelAttribute="newUser">
    <div class="form-group">
        <label>User Name:</label>
        <form:input path="userName" class="form-control"/>
        <form:errors path="userName" class="text-danger"/>
    </div>
    <div class="form-group">
        <label>Email:</label>
        <form:input path="email" class="form-control"/>
        <form:errors path="email" class="text-danger"/>
    </div>
    <div class="form-group">
        <label>Password:</label>
        <form:password path="password" class="form-control"/>
        <form:errors path="password" class="text-danger"/>
    </div>
    <div class="form-group">
        <label>Confirm Password:</label>
        <form:password path="confirm" class="form-control"/>
        <form:errors path="confirm" class="text-danger"/>
    </div>
    <br>
    <input type="submit" value="Register" class="btn btn-primary"/>
</form:form>
<br> <br> <br>
<%--@elvariable id="newLogin" type=""--%>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <div class="form-group">
        <label>Email:</label>
        <form:input path="email" class="form-control"/>
        <form:errors path="email" class="text-danger"/>
    </div>
    <div class="form-group">
        <label>Password:</label>
        <form:password path="password" class="form-control"/>
        <form:errors path="password" class="text-danger"/>
    </div>
    <br>
    <input type="submit" value="Login" class="btn btn-success"/>
</form:form>

</body>
</html>