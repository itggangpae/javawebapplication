<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="Intro" />
<html>
    <head><title><fmt:message key="title" /></title></head>
    <body>
        <h3><fmt:message key="title" /></h3>
        <fmt:message key="GREETING" /> <br /><br />
        <fmt:message key="body" /> <br /><br />
        <font size=2><fmt:message key="COMPANY_NAME" /></font>
    </body>
</html>
