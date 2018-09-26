<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 25/6/17
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body onload="getUserData();">
    <div id="userDataContainer" class="row auto-scroll-y">
        <table id="userData" name="userData" class="table table-striped">
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>Role</th>
                </tr>
            </thead>
        </table>
    </div>
    <!-- Modal -->
    <button type="button" id="modelOpener" class="hidden" data-toggle="modal" data-target="#userInfoModal">Model</button>
    <div class="modal fade" id="userInfoModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="userInfoModal">&times;</button>
                    <h4 class="modal-title">Manage User</h4>
                </div>
                <div id="userInfoModalData" class="modal-body">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</body>