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
        |   <a href="/dashboard">Dashboard</a> |
    </nav>
    <br>
    <h5 style="font-family: monospace">Edit your Trip:</h5>
    <br>
    <div>
     
        <%--@elvariable id="trip" type="trip"--%>
        <form:form method="post" action="/edit/trip/${trip.id}" modelAttribute="trip">
            <div>
			<span>
				<form:label path="title">Trip Title</form:label>
			</span>
                <form:input path="title" type="text" value="${currentTrip.title }"/>
                <form:errors path="title" cssStyle="color: red"/>
            </div>
            <br>
            <div>
			<span>
				<form:label path="capacity">Capacity</form:label>
			</span>
                <form:input path="capacity" type="number" value="${currentTrip.capacity }"/>
                <form:errors path="capacity" cssStyle="color: red"/>
            </div>

            <br>
            <div>
			<span>
				<form:label path="details">Details</form:label>
			</span>
                <form:input path="details" type="text" value="${currentTrip.details }"/>
                <form:errors path="details" cssStyle="color: red"/>
            </div>

            <input type="hidden" name="user" value="${userName.id }"/>
            <form:input type="hidden" path="players"/>
            <br>
            <input type="submit" value="Edit Trip" class="btn btn-success"/>
        </form:form>
        <br>
    </div>
    <a href="/delete/trip/${trip.id }" class="btn btn-danger"> Delete Trip</a>
</div>
</body>
</html>