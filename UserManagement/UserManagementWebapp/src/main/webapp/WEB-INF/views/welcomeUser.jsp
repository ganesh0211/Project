<%--
  Created by IntelliJ IDEA.
  User: ganesh
  Date: 26/5/16
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <div><%=request.getAttribute("userName")%></div>
            </td>
        </tr>
        <tr>
           <td>
               <div></div>
           </td>
        </tr>

    </table>
    Username :
    <br />
    Email : <%=request.getAttribute("email")%>
    <br />
    Number : <%=request.getAttribute("contactNumber")%>
</body>
</html>