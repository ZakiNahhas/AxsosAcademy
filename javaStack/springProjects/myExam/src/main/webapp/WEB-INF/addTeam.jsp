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
        <a href="/dashboard">Dashboard</a> |

        <a href="/logout">Logout</a>
    </nav>
    <br>
    <h5 style="font-family: monospace">Add a Trip</h5>
    <br>
    <div class="flex">
        <%--@elvariable id="team" type="team"--%>
        <form:form method="post" action="/add/trip" modelAttribute="team">
            <div>
			<span>
				<form:label path="name"> Trip title: </form:label>
			</span>
                <form:input path="name" type="text"/>
                <form:errors path="name"/>
                <p>${error }</p>
            </div>

            <br>
            <div>
			<span>
				<form:label path="level">Capacity: </form:label>
			</span>
                <form:input path="level" type="number"/>
                <form:errors path="level"/>
                                    <p>${error }</p>
            </div>
            <div>
                <br>
			<span>
				<form:label path="day">Details: </form:label>
			</span>
                <form:input path="day" type="text"/>
                <form:errors path="day"/>
            </div>

            <br>
            <input type="hidden" name="user" value="${userName.id }"/>

            <input type="submit" value="Add a Trip" class="btn btn-success"/>
        </form:form>

    </div>
</div>
</body>
</html>