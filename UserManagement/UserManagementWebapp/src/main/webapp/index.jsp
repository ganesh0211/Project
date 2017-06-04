<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.ContextLoader" %>
<%@ page import="org.usermanagement.core.db.PersistenceHandler" %>
<%@ page import="org.usermanagement.core.db.PersistenceHandlerImpl" %>
<%@ page import="org.model.usermanagement.User" %>
<html>
<body>
<h2>Hello World!</h2>
<%

    WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
    PersistenceHandler persistenceHandler = applicationContext.getBean(PersistenceHandlerImpl.class);
    User user = new User();
    user.setUsername("A");
    user.setPassword("ABC");
    user.setContactNumber("917293712");
    user.setContactEmail("A@A.com");
    persistenceHandler.saveObject(user);

%>
</body>
</html>
