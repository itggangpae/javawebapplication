<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext 테스트</title>
</head>
<body>
	<p>페이지 컨텍스트 테스트</p>
	<%
		pageContext.include("c.jsp");
	%>
</body>
</html>
