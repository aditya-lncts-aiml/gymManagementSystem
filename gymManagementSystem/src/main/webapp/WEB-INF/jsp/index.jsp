<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
            <li><a href="/customer-modification">CUSTOMERS</a></li>
            <li><a href="/gymitem">ADD ITEMS</a></li>
            <li><a href="/gymitems">GYM ITEMS</a></li>
            <li><a href="/slotentry">ADD SLOT</a></li>
            <li><a href="/edit-slot">EDIT SLOT</a></li>
            <li><a href="/slotreport">SLOTS</a></li>
            <li><a href="/feedback-report">FEEDBACKS</a></li>
            <li><a href="/booked">BOOKED SLOTS</a></li>
            <li><a href="/logout">LOGOUT</a></li>
        </ul>
    </div>
    <div class="welcome-message">
        <h1>Welcome to Gym Management System</h1>
    </div>
    <footer>
     Copyright © 2024 Infosys Interns Fitness Club. All Rights Reserved
    </footer>
</body>
</html>