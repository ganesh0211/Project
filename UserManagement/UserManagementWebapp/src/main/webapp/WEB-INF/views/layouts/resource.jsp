<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 2/10/18
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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