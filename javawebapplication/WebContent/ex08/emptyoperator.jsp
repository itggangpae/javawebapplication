<%@page contentType="text/html; charset=utf-8" %>
<HTML>
    <HEAD><TITLE>엠프티 연산자</TITLE></HEAD>
    <BODY>
        안녕하세요, ${empty param.ID ? "guest" : param.ID}님
    </BODY>
</HTML>