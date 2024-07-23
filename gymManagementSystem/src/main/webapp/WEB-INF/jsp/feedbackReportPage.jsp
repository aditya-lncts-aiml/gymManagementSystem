<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Report</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/slotReportPage.css" %>
</style>
</head>
<body>
<div class="container">
<table>
<caption><h1><i>Feedbacks</i></h1></caption>
<tr>
<th>Username</th>
<th>Email Id</th>
<th>Name</th>
<th>How was your experience?</th>
</tr>
<c:forEach items="${feedback}" var="fb">
<tr>
<td>${fb.username}</td>
<td>${fb.email}</td>
<td>${fb.name}</td>
<td>${fb.content}</td>
</tr>
</c:forEach>
</table>
<div class="return">
<a href="/index"><button type="button">Return</button></a>
</div>
</div>
</body>
</html>
