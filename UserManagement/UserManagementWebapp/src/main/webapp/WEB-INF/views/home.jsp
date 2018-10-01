<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
Greeting : ${greeting}

<form action="../oauth/token" method="POST">
    <input type="button" value="Auth" onclick="getAuthCode()">
    <input type="button" value="token" onclick="getAccessToken()">
</form>
</body>
</html>