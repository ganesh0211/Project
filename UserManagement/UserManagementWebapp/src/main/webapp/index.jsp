<html>
<body>
<h2>Hello World!</h2>
<%
    org.usermanagement.platform.db.PersistenceHandler persistenceHandler = org.usermanagement.platform.db.PersistenceHandler.getInstance();
    org.usermanagement.model.User user = new org.usermanagement.model.User();
    user.setUsername("A");
    user.setPassword("ABC");
    user.setContactNumber("917293712");
    user.setContactEmail("A@A.com");

    persistenceHandler.saveObject(user);

%>
</body>
</html>
