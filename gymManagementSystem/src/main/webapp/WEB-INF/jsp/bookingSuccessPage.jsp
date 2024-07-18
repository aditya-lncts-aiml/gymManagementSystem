<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/bookingSuccessPage.css" %>
</style>
</head>
<body>
<div class="container">
    <div class="data">
        <h1>Booking Successfull</h1>
        <p>Booking ID: ${booking.bookingId}</p>
        <p>Slot ID: ${booking.slotId}</p>
        <p>Username: ${booking.username}</p>
        <p>Item ID: ${booking.itemId}</p>
        <a href="/index"><button type="button">Return to Home</button></a>
    </div>
</div>
</body>
</html>

