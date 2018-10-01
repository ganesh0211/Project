<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 30/9/18
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title></title>
</head>
<body onload="getAccessToken('${code}','http://localhost:8080/Dashboard/oauth2/accessToken')">
<div id="oathAuthorizeContent" class="hidden">
</div>
</body>
</html>