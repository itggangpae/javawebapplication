<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리다이렉트</title>
</head>
<body>
	<% 
		//response.sendRedirect("http://www.naver.com/"); 
		String value = "자바";
		value = java.net.URLEncoder.encode(value, "utf-8");
		response.sendRedirect("result.jsp?name=" + value);
	
	%>
</body>
</html>
