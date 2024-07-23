<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Customer</title>
<style type="text/css">
<%@ include file="/WEB-INF/css/deleteCustomerPage.css" %>
</style>
</head>
<body>
<div class="container">
    <h1>Delete Customer</h1>
    <div class="customer-table">
        <table>
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list}</td>
                    <td>
                        <a href="/delete-customer/${list}" class="delete-link">
                            <button type="button" class="delete-btn">Delete</button>
                        </a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="return-container">
        <a href="/index"><button type="button" class="return-btn">Return</button></a>
    </div>
</div>
</body>
</html>
