<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookings</title>
</head>
<style type="text/css">
<%@ include file="/WEB-INF/css/slotBookPage.css" %>
</style>
<script type="text/javascript">
    function checkSelection() {
        var items = document.getElementsByName('selectBookingId');
        var submitButton = document.getElementById('submit-button');
        var selected = false;
        
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                selected = true;
                break;
            }
        }

        submitButton.disabled = !selected;
    }

    window.onload = function() {
        checkSelection();
        var items = document.getElementsByName('selectBookingId');
        for (var i = 0; i < items.length; i++) {
            items[i].addEventListener('change', checkSelection);
        }
    }
</script>
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
                        <input name="selectBookingId" type="radio" value="${gbList.bookingId}"/>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <div class="button-container">
                <button id="submit-button" type="submit">Cancel</button>
                <a href="/index"><button type="button">Return</button></a>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
