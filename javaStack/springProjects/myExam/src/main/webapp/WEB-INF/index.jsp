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
    <h1 style="text-align: center">Welcome</h1>

    <div style="display: flex; justify-content: space-around">
        <div class="col-2">
            <h2>Register</h2>
            <%--@elvariable id="newUser" type="newUser"--%>
            <form:form method="post" action="/register" modelAttribute="newUser">
                <div>
						<span>
							<form:label path="userName">User Name:</form:label>
						</span>
                    <form:input path="userName" type="text"/>
                    <form:errors path="userName" cssStyle="color: red"/>
                </div>


                <div>
						<span>
							<form:label path="email">Email:</form:label>
						</span>
                    <form:input path="email" type="email"/>
                    <form:errors path="email" cssStyle="color: red"/>
                </div>

                <div>
						<span>
							<form:label path="password">Password:</form:label>
						</span>
                    <form:input path="password" type="password"/>
                    <form:errors path="password" cssStyle="color: red"/>
                </div>

                <div>
						<span>
							<form:label path="confirm">Confirm Password:</form:label>
						</span>
                    <form:input path="confirm" type="password"/>
                    <form:errors path="confirm" cssStyle="color: red"/>
                </div>
                <br>
                <input type="submit" value="Register" class="btn btn-dark"/>
            </form:form>
        </div>
        <div class="col-2">
            <h2>Login</h2>

            <%--@elvariable id="newLogin" type="newLogin"--%>
            <form:form method="post" action="/login" modelAttribute="newLogin">
                <div>
						<span>
							<form:label path="email">Email:</form:label>
						</span>
                    <form:input path="email" type="email"/>
                    <form:errors path="email" cssStyle="color: red"/>
                </div>
                <div>
						<span>
							<form:label path="password">Password:</form:label>
						</span>
                    <form:input path="password" type="password"/>
                    <form:errors path="password" cssStyle="color: red"/>
                </div>
                <br>
                <input type="submit" value="Login" class="btn btn-info"/>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>