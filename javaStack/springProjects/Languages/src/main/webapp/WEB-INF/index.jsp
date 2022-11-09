<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<table class="table col-6">
    <thead>
    <tr>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="language" items="${language}">
        <tr>
            <td><a href="/language/${language.id}"><c:out value="${language.name}"></c:out><a/></td>
            <td><c:out value="${language.creator}"></c:out></td>
            <td> <c:out value="${language.version}"></c:out></td>
            <td><a href="/languages/${language.id}/edit">edit</a>
            <td><form action="/${language.id}/delete" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form></td>
        </tr>
    </c:forEach>
    <!-- loop over all the books to show the details as in the wireframe! -->
    </tbody>
</table>
<h1>Add Language</h1>
<table class="table col-6">
    <%--@elvariable id="language" type=""--%>
    <form:form action="/language" method="post" modelAttribute="language">
        <div>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </div>
        <div>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </div>
        <div>
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>
            <form:input path="version"/>
        </div>
        <input type="submit" value="Submit"/>
    </form:form>
</table>
</body>
</html>