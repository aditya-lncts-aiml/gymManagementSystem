<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/exceptionPage.css" %>
</style>
</head>
<body>
<div class="container">
    <div class="data">
        <p>Oh! Sorry</p>
        <p>${errorMessage}</p>
        <a href="/index"><button type="button">Return to Home</button></a>
    </div>
</div>
</body>
</html>