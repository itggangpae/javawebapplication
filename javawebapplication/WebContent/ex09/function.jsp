<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="greeting" value="How Are You?" />
<html>
    <head><title>문자열 함수</title></head>
    <body>
        본래의 문자열: ${greeting} <br />
        모두 대문자로: ${fn:toUpperCase(greeting)} <br />
        모두 소문자로: ${fn:toLowerCase(greeting)} <br />
        Are의 위치는? ${fn:indexOf(greeting, "Are")} <br />
        Are를 Were로 바꾸면? ${fn:replace(greeting, "Are", "Were")} <br />
        문자열의 길이는? ${fn:length(greeting)} <br />
    </body>
</html>