<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Slot</title>
    <style>
        <%@include file="/WEB-INF/css/gymItemEntryPage.css"%>
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Slot</h1>
        <form:form id="edit-item-form" action="/slot/update" method="post" modelAttribute="slotRecord">
            <div>
                <label for="slotTime">Slot Time: ${slotTime}</label>
                <form:input path="slotTime"/>
            </div>
            <form:hidden path="slotId"/>
            <div>
                <label for="pricing"> Price :</label>
                <form:input path="pricing" required="required"/>
            </div>
            <button type="submit">Update</button>
            <br/>
            <button type="reset">Reset</button>
            <br/>
            <a href="/index"><button type="button">Home</button></a>
        </form:form>
    </div>
</body>
</html>
