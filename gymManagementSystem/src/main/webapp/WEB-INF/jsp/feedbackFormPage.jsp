<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
<style>
        <%@include file="/WEB-INF/css/feedbackFormPage.css"%>
    </style>
</head>
<body>
<div class="container" align="center">
    <h1>Feedback Form</h1>
    <form:form action="/submit-feedback" method="post" modelAttribute="feedback" class="feedback-form">
        <form:hidden path="username"/>
        <form:hidden path="email"/>
        <div class="form-group">
            <label for="name">Enter Name:</label>
            <form:input path="name" id="name" class="form-input"  required="required"/>
        </div>
        <div class="form-group">
            <label for="content">Enter Text:</label>
            <form:textarea rows="5" cols="50" path="content" id="content" class="form-textarea"  required="required"/>
        </div>
        <div class="button-container">
            <button type="submit" class="submit-btn">Submit</button>
            <button type="reset" class="reset-btn">Reset</button>
        </div>
        <div class="return-container">
            <a href="/index" class="return-link">Return</a>
        </div>
    </form:form>
</div>
</body>
</html>
