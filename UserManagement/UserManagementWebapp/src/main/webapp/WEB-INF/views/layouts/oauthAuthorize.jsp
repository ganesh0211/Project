<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 22/6/17
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body style='font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif' <decorator:getProperty property="body.onload" writeEntireProperty="true"/>>
<div id="oathAuthorizationView" class="panel panel-info" style="width:400px;">
    <div class="panel-heading">Request for OAuth Authorization [<b><%=request.getParameter("client_id")%></b>] </div>
    <div class="panel-body" style="background-color:#EEEEEE;">
        <form>
            <div class="row">
                <img class="col-sm-3" src="<c:url value='../static/images/authorize.png' />" title="Access" height="50px" width="50px">
                <div class="headerMediumFont col-sm-6" style="line-height: 100%;">
                    <%=((request.getParameter("scope") != null )?request.getParameter("scope").toUpperCase()+" access":"General access")%>
                    <div class="descriptionSmallFont" >
                        Approving will provide the above noted access
                        to the resources.
                    </div>
                </div>
            </div>
            <%User user = (SecurityContextHolder.getContext().getAuthentication() != null )? (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal() :null;%>
            <% if(user != null) { %>
                <div class="row" style="line-height: 30px; margin-top: 5px;">
                    <img class="col-sm-3"  src="<c:url value='../static/images/administrator.png' />" title="Logged User" height="40px" width="40px">
                    <div class="headerMediumFont col-sm-6" style="line-height: 100%;">
                        <%=user.getUsername()%>
                        <div class="descriptionSmallFont" >
                            Role: <%=user.getAuthorities()%>
                        </div>
                    </div>
                </div>
            <%}%>
        </form>
    </div>
    <div class="panel-footer">
        <div>
            <input type="button" class="btn btn-default pull-right " onclick="document.getElementById('confirmationForm').submit();" autofocus="true" value="Approve"/>
            <input type="button" class="btn btn-default" onclick="document.getElementById('denialForm').submit();" value="Deny">
        </div>
    </div>

</div>

</div>
<div id="oathAuthorizeContent" class="hidden">
    <decorator:body />
</div>
</body>
</html>