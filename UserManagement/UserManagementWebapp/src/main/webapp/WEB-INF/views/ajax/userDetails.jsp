<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 23/6/17
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<c:url var="updateUserDetails" value="/updateUserDetails"/>
<form action="${updateUserDetails}" method="post">
    <div class="form-group hidden">
        <label for="id">Id</label>
        <input type="text" class="form-control" id="id" name="id" placeholder="Id" value="${id}">
    </div>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${firstName}">
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${lastName}">
    </div>
    <div class="form-group">
        <label for="middleName">Middle Name</label>
        <input type="text" class="form-control" id="middleName" name="middleName" placeholder="Middle Name" value="${middleName}">
    </div>
    <div class="form-group">
        <label for="username">username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username" value="${username}">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${password}">
    </div>

    <div class="form-group">
        <label for="contactEmail">Email</label>
        <input type="email" class="form-control" id="contactEmail" name="contactEmail" placeholder="Email" value="${contactEmail}">
    </div>
    <div class="form-group">
        <label for="contactNumber">Contact Number</label>
        <input type="tel" class="form-control" id="contactNumber"  name="contactNumber" placeholder="Contact Number" value="${contactNumber}">
    </div>
    <div class="form-group">
        <label for="role.name">Role</label>
        <input type="text" class="form-control hidden" id="role.id"  name="role.id" placeholder="Role.id" value="${role_id}">
        <input type="text" class="form-control" id="role.name"  name="role.name" placeholder="Role" value="${role_name}">
    </div>
    <div class="form-group">
        <label for="userGroup.name">userGroup</label>
        <input type="text" class="form-control hidden" id="userGroup.id"  name="userGroup.id" placeholder="userGroup.id" value="${userGroup_id}">
        <input type="text" class="form-control" id="userGroup.name"  name="userGroup.name" placeholder="UserGroup" value="${userGroup_name}">
    </div>

    <div class="form-group">
        <label for="manager.name">Manager</label>
        <input type="text" class="form-control hidden" id="manager.id"  name="manager.id" placeholder="manager.id" value="${manager_id}">
        <input type="text" class="form-control" id="manager.name"  name="manager.name" placeholder="Manager" value="${manager_name}">
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</form>