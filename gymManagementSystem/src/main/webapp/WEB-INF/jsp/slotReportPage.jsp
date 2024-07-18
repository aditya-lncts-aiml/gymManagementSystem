<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slot Report</title>
<style type="text/css">
<%@include file="/WEB-INF/css/slotReportPage.css"%>
</style>
</head>
<body>
<div class="container" >
<form action="/slotreport" method="post">
<table >
<caption><h1><i>Slots</i></h1></caption>
<tr>
<th>Slot Id</th>
<th>Slot Time</th>
<th>Slot Price</th>
<th>Enquire</th>
</tr>
<c:forEach items="${slotList}" var="slot">
<tr>
<td>${slot.slotId}</td>
<td>${slot.slotTime}</td>
<td>${slot.pricing}</td>
<td><a href="/slot-book/${slot.slotId}">Enquire</a></td>
</tr>
</c:forEach>
</table>
<div class="return">
<a href="/index"><button type="button">Return</button></a>
</div>
</form>
</div>
</body>
</html>