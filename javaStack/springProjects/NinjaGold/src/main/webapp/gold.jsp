<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3>Your Gold: <input class="input" type="text" placeholder=${money}></h3>
<div class="flex">
    <form action="/process_money" method="POST">
        <div class="box">
            <input type="hidden" name="money" value="farm">
            <p>Farm</p>
            <p>(earns 10-20 gold)</p>
            <input class="btn" type="submit" value="Find Gold!">
        </div>
    </form>
    <form action="/process_money" method="POST">
        <div class="box">
            <input type="hidden" name="money" value="cave">
            <p>Cave</p>
            <p>(earns 10-20 gold)</p>
            <input class="btn" type="submit" value="Find Gold!">
        </div>
    </form>
    <form action="/process_money" method="POST">
        <div class="box">
            <input type="hidden" name="money" value="house">
            <p>House</p>
            <p>(earns 10-20 gold)</p>
            <input class="btn" type="submit" value="Find Gold!">
        </div>
    </form>
    <form action="/process_money" method="POST">
        <div class="box">
            <input type="hidden" name="money" value="quest">
            <p>Quest</p>
            <p>(earns/takes 10-50 gold)</p>
            <input class="btn" type="submit" value="Find Gold!">
        </div>
    </form>
</div>
<form class="reset" action="/reset">
    <input class="btn" type="submit" value="Reset ME!">
</form>
<h4>Activities:</h4>

<div class="text" name="activities">
    {% for elem in request.session.activities reversed%}
    {% if 'failed' in elem %}
    <p style="color:red ;">{{elem}}</p>
    {% else %}
    <p style="color: green;">{{elem}}</p>
    {%endif%}
    {% end-for %}
</div>
</body>
</html>