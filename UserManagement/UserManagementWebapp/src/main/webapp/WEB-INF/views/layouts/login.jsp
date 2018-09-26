<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 15/6/17
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title>User Management</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
    <decorator:head />
</head>
<body <decorator:getProperty property="body.onload" writeEntireProperty="true"/>>
<jsp:include page="loginHeader.jsp" />
<decorator:body />
</body>
</html>
