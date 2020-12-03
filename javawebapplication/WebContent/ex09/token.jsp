<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>프로야구</title></head>
    <body>
        내가 좋아하는 사람들 <br /><br />
        <c:set var="players" value="최향남^^이대진~이종범" />
        <c:forTokens var="player" items="${players}" delims="^~" > 
            ${player} <br />
        </c:forTokens>
    </body>
</html> 
