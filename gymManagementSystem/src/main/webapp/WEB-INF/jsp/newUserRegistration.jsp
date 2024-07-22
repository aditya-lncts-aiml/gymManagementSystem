<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
<style>
    <%@include file="/WEB-INF/css/newUserRegistration.css"%>
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
<%@include file="/WEB-INF/js/newUserRegistration.js" %>
</script>
</head>
<body>
<div class="container">
<h2>New User Registration</h2>
<form:form id="registration-form" method="post" onsubmit="return validateForm()" action="/register" modelAttribute="userRecord">
    Enter first name: <form:input path="firstName" placeholder="First Name" required="required"/>
    <br/><br/>
    Enter last name: <form:input path="lastName" placeholder="Last Name" required="required"/>
    <br/><br/>
    Enter email: <form:input path="email" id="email" placeholder="Email Id" required="required"/>
    <br/><br/>
    Select User's Type: <form:input list="types" name="type" path="type" placeholder="User Type" required="required"/>
    <datalist id="types">
        <option value="Customer">
        <option value="Admin">
    </datalist>
    <br/><br/>
    Enter user Id: <form:input path="username" id="username" placeholder="Username" required="required"/>
    <br/><br/>
    Enter Phone No.: <form:input path="phone_number" id="phone_number" type="text" maxlength="10" pattern="\d{10}" placeholder="Phone Number" required="required"/>
    <br/><br/>
    Enter password: <form:input type="password" path="password" id="pass1" placeholder="Password" required="required"/>
    <br/><br/>
    Re-type password: <input type="password" id="pass2" placeholder="Confirm Password" required="required"/>
    <br/><br/>
    <div align="center">
    <button type="submit">Submit</button>
    <button type="reset">Reset</button>
    </div>
    <br/>
    <div align="center">
    <span>Already registered? <a href="/loginpage">Login here</a></span>
    </div>
</form:form>
</div>
</body>
</html>
