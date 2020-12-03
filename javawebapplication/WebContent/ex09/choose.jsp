<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>인사하기</title></head>
    <body>
        <c:choose> 
            <c:when test="${param.NUM == 0}"> 
                처음 뵙겠습니다. <br />
            </c:when> 
            <c:when test="${param.NUM == 1}"> 
                반갑습니다. <br />
            </c:when> 
            <c:otherwise> 
                안녕하세요. <br />
            </c:otherwise> 
        </c:choose> 
    </body>
</html> 