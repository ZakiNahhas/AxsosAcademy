<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
    </tr>
    </thead>
    <tr>
        <td> <c:out value="${language.name}"></c:out> </td>
        <td><c:out value="${language.creator}"></c:out></td>
        <td><c:out value="${language.version}"></c:out></td>
    </tr>
</table>
</body>
</html>