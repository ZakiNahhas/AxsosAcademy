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
<h3>Send an Omikuji</h3>
<form action='/handle' method='post'>
    <label>
        Pick any number from 5 to 25
        <input type="number" name="number" max="25" min="5">
    </label>
    <label>Enter the name of a city:</label>
    <input type="text" name='city'>
    <label>Enter the name of any real person:</label>
    <input type='text' name='realPerson'>
    <label>
        Enter professional endeavor or hobby:
        <input type="text" name="endeavor">
    </label>
    <label>
        Enter any type of living thing:
        <input type="text" name="livingThing">
    </label>
    <label>
        Say something nice to someone:
        <textarea name="smthNice" cols="40" rows="5"></textarea>
    </label>
    <h5>Send and show a friend</h5>
    <input type='submit' value='Send'>
</form>
</body>
</html>