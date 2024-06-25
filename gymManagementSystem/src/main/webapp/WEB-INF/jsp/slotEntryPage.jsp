<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slot Entry</title>
<style>
   <%@include file="/WEB-INF/css/slotEntryPage.css"%>
</style>
</head>
<body>
<div class="container">
    <h1>Manage Slot</h1>
    <form:form id="slot-entry-page" action="/slotentry" method="post" modelAttribute="slotRecord">
        <div>
            <label for="slotTime">Slot Time:</label>
            <form:input path="slotTime" required="required"/>
        </div>
        <form:hidden path="slotId"/>
        <div>
            <label for="pricing">Pricing:</label>
            <form:input path="pricing" required="required"/>
        </div>
        <div>
            <button type="submit">Add Slot</button>
            <button type="reset">Reset</button>
            <a href="/index" ><button type="button">Return</button></a>
        </div>
    </form:form>
    
    <table border="2">
            <thead>
                <tr>
                    <th>Slot Id</th>
                    <th>Slot Timing</th>
                    <th>Slot Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="slot" items="${slotList}">
                    <tr>
                        <td>${slot.slotId}</td>
                        <td>${slot.slotTime}</td>
                        <td>${slot.pricing}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</div>
</body>
</html>
