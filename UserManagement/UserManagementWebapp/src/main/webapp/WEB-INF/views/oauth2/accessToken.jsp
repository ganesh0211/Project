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
    <%String contextPath = request.getContextPath()+"/";%>
    <link href="<%=contextPath%><c:url value='static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<%=contextPath%><c:url value='static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
    <script src="<%=contextPath%><c:url value='static/js/jQuery.min.js' />"></script>
    <script src="<%=contextPath%><c:url value='static/js/bootstrap.min.js' />"></script>
    <script src="<%=contextPath%><c:url value='static/js/jquery.dataTables.min.js' />"></script>
    <script src="<%=contextPath%><c:url value='static/js/bootstrap.dataTables.min.js' />"></script>
    <script src="<%=contextPath%><c:url value='static/js/menu.js' />"></script>
    <script src="<%=contextPath%><c:url value='static/js/app.js' />"></script>
</head>
<body onload="getAccessToken('${code}','http://localhost:8080/Dashboard/oauth2/accessToken')">
<div id="oathAuthorizeContent" class="hidden">
</div>
</body>
</html>