<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.ContextLoader" %>
<%@ page import="org.usermanagement.platform.db.PersistenceHandler" %>
<%@ page import="org.usermanagement.platform.db.PersistenceHandlerImpl" %>
<html>
<body>
<h2>Hello World!</h2>
<%

    WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
    PersistenceHandler persistenceHandler = applicationContext.getBean(PersistenceHandlerImpl.class);
    org.usermanagement.model.User user = new org.usermanagement.model.User();
    user.setUsername("A");
    user.setPassword("ABC");
    user.setContactNumber("917293712");
    user.setContactEmail("A@A.com");
    persistenceHandler.saveObject(user);

%>
</body>
</html>
