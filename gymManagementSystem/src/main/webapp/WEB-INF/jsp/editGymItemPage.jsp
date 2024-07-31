<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Exercise</title>
    <style>
        <%@include file="/WEB-INF/css/gymItemEntryPage.css"%>
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Exercise</h1>
        <form:form id="edit-item-form" action="/gymitem/update" method="post" modelAttribute="itemRecord">
            <div>
                <label for="itemName">Exercise Name: ${itemName}</label>
                <form:input path="itemName"/>
            </div>
            <form:hidden path="itemId"/>
            <div>
                <label for="totalSeat">Total Seat:</label>
                <form:input path="totalSeat" required="required"/>
            </div>
            <button type="submit">Update Exercise</button>
            <br/>
            <button type="reset">Reset</button>
            <br/>
            <a href="/index"><button type="button">Home</button></a>
        </form:form>
    </div>
</body>
</html>
