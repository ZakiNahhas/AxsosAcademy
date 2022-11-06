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
<h1>Edit Expense: </h1>
<%--@elvariable id="saveTravels" type=""--%>
<form:form action="/editExpenses/${saveTravels.id}" method="post" modelAttribute="saveTravels">
    <input type="hidden" name="_method" value="put">

    <p>
        <form:label path="expense">Expense name: </form:label>
        <form:input path="expense"/>
        <form:errors path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor: </form:label>
        <form:input path="vendor"/>
        <form:errors path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount: </form:label>
        <form:input type="number" path="amount"/>
        <form:errors path="amount"/>
    </p>
    <p>
        <form:label path="description">Description: </form:label>
        <form:textarea path="description"/>
        <form:errors path="description"/>
    </p>
    <input class="bg-danger" type="submit" value="Submit"/>
</form:form>
</body>
</html>