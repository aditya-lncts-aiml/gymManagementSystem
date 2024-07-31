<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookings</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/slotBookPage.css" %>
</style>
</head>
<body>
<div class="container">
    <h1>Bookings</h1>
    <div class="form-container">
        <form:form action="/booked" method="post" ModelAttribute="bookList">
            <table>
                <tr>
                    <th>Booking Id</th>
                    <th>Slot ID</th>
                    <th>Item ID</th>
                    <th>Username</th>
                    <th>Select</th>
                </tr>
                <c:forEach items="${gbList}" var="gbList">
                <tr>
                    <td>${gbList.bookingId}</td>
                    <td>${gbList.slotId}</td>
                    <td>${gbList.itemId}</td>
                    <td>${gbList.username}</td>
                    <td>
                        <input name="selectBookingId" type="radio" value="${gbList.bookingId}" required="required"/>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <div class="button-container">
                <button id="submit-button" type="submit">Cancel</button>
                <a href="/index"><button type="button">Return</button></a>
                <button type="reset">Reset</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
