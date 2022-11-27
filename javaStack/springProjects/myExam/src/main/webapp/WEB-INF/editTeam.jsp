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

    </nav>
    <h5 style="font-family: monospace">Edit your Trip</h5>
    <h3></h3>
    <div>
        <%--@elvariable id="team" type="team"--%>
        <form:form method="post" action="/edit/trip/${team.id}" modelAttribute="team">
            <div>
			<span>
				<form:label path="name">Trip Title</form:label>
			</span>
                <form:input path="name" type="text" class="giveteam" value="${currentTeam.name }"/>
                <form:errors path="name" class="error"/>

            </div>
            <br>
            <div>
			<span>
				<form:label path="level">Capacity</form:label>
			</span>
                <form:input path="level" type="number" value="${currentTeam.level }"/>
                <form:errors path="level" class="error"/>
                <p>${error }</p>

            </div>

            <br>
            <div>
			<span>
				<form:label path="day">Details</form:label>
			</span>
                <form:input path="day" type="text" value="${currentTeam.day }"/>
                <form:errors path="day" class="error"/>
            </div>


            <input type="hidden" name="user" value="${userName.id }"/>
            <form:input type="hidden" path="players"/>
            <br>
            <input type="submit" value="Edit Trip" class="btn btn-success"/>
        </form:form>
            <br>
    </div>
    <a href="/delete/trip/${team.id }" class="btn btn-danger"> Delete Team</a>
</div>
</body>
</html>