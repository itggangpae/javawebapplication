<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head><title>Enumerator</title></head>
    <body>
        <c:forEach var="cnt" begin="1" end="5"> 
            <font size=${cnt} > 프로야구 </font> <br />
        </c:forEach> 
<%
    String ar[] = { "최향남", "이대진", "이종범" };
    request.setAttribute("friends", ar);
%>    
        <h3>좋아하는 사람들</h3>
        <ul>
            <c:forEach var="player" items="${friends}">
                <li>${player}</li>
            </c:forEach>
        </ul>
        
    </body>
</html> 