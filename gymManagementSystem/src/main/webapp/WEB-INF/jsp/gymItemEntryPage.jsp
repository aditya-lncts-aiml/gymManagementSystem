<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Exercises</title>
    <style>
        <%@include file="/WEB-INF/css/gymItemEntryPage.css"%>
    </style>
</head>
<body>
    <div class="container">
        <h1>Manage Exercises</h1>
        <form:form id="trainer-page" action="/gymitem" method="post" modelAttribute="itemRecord">
            <div>
                <label for="itemName">Exercise Name:</label>
                <form:input path="itemName" required="required"/>
            </div>
            <form:hidden path="itemId"/>
            <div>
                <label for="totalSeat">Total Seat:</label>
                <form:input path="totalSeat" required="required"/>
            </div>
            <button type="submit">Add Exercise</button>
            <br/>
            <button type="reset">Reset</button>
            <br/>
            <a href="/index" ><button type="button">Return</button></a>
        </form:form>
        <table>
            <thead>
                <tr>
                    <th>Item Id</th>
                    <th>Item Name</th>
                    <th>Total Seat</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${itemList}">
                    <tr>
                        <td>${item.itemId}</td>
                        <td>${item.itemName}</td>
                        <td>${item.totalSeat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
</body>
</html>
