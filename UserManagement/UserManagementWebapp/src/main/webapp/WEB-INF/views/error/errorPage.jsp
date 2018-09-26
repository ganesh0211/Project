<%--
  Created by IntelliJ IDEA.
  User: ganes
  Date: 3/7/17
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
      <div class="row headerMediumFont">
          Something went wrong !!! Please contact admin.
          <div>
              <textarea contenteditable="false" style="width: 60%;">
                  Failed URL: ${url} <br />
                  Exception:  ${exception.message}
                  <c:forEach items="${exception.stackTrace}" var="stackTraceLine">
                    ${stackTraceLine}
                  </c:forEach>
              </textarea>
          </div>

      </div>
</body>