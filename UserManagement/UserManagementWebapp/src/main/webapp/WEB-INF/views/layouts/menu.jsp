<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 25/6/17
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String contextPath = request.getContextPath()+"/";%>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Sidebar -->
<div id="sidebar-wrapper">
    <ul id="sidebar_menu" class="sidebar-nav">
        <li class="sidebar-brand">
            <a id="menu-toggle" onclick="toggle();" href="#">Menu<span id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
    </ul>
    <ul class="sidebar-nav" id="sidebar">
        <li><a href="<%=contextPath%>userInfo/manage">Dashboard<span class="sub_icon glyphicon glyphicon-home"></span></a></li>
        <li><a href="<%=contextPath%>userInfo/manage">View Users Info<span class="sub_icon glyphicon glyphicon-user"></span></a></li>
        <li><a href="<%=contextPath%>userInfo/manage">Edit<span class="sub_icon glyphicon glyphicon-edit"></span></a></li>
    </ul>
</div>
</body>
</html>