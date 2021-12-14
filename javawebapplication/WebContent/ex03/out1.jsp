<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out객체</title>
</head>
<body>
	<%
		out.println("출력 결과 <br />");
	%>
	버퍼 크기:
	<%=out.getBufferSize()%>
	<br /> 남은 크기:
	<%=out.getRemaining()%>
	<br /> auto flush:
	<%=out.isAutoFlush()%>
	<br />
</body>
</html>
