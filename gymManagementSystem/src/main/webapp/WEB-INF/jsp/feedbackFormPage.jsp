<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
<style type="text/css">
</style>
</head>
<body>
<div class="container">
    <h1>Feedback Form</h1>
    <form:form action="/submit-feedback" method="post" modelAttribute="feedback">
    <form:input type="hidden" path="id" />
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" type="text" id="name" required="true"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" type="email" id="email" required="true"/>
        </div>
        <div class="form-group">
            <label for="rating">Rating:</label>
            <form:select path="rating" id="rating">
                <form:option value="1">1</form:option>
                <form:option value="2">2</form:option>
                <form:option value="3">3</form:option>
                <form:option value="4">4</form:option>
                <form:option value="5">5</form:option>
            </form:select>
        </div>
        <div class="form-group">
            <label for="comments">Comments:</label>
            <form:textarea path="comments" id="comments" rows="5" cols="30"/>
        </div>
        <div class="form-group">
            <button type="submit">Submit Feedback</button>
        </div>
    </form:form>
</div>
</body>
</html>
