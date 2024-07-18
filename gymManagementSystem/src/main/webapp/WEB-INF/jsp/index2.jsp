<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online GYM Management System</title>
    <style>
        <%@include file="/WEB-INF/css/index.css"%>
    </style>
    <script type="text/javascript">
        function fun() {
            alert(${output});
        }
    </script>
</head>
<body>
    <div class="navbar">
        <div class="logo">STAMINA.</div>
        <ul>
            <li><a href="/index" class="active">HOME</a></li>
            <li><a href="/slotreport">SLOT BOOKING</a></li>
            <li><a href="/booked">BOOKED SLOTS</a></li>
            <li><a href="/feedback">FEEDBACK</a></li>
            <li><a href="/logout">LOGOUT</a></li>
        </ul>
    </div>
    <div class="welcome-message">
        <h1>Welcome to Gym Management System</h1>
    </div>
    <!--<footer>
    <p>&copy; 2024 Online Gym Management System. All rights are reserved</p>
    </footer>-->
</body>
</html>
