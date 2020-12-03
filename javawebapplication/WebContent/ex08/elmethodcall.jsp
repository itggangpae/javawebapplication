<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL에서 메소드 호출</title>
</head>
<body>
	<%@ page import="ex08.*" %>
	<% request.setAttribute("sample", new Sample()); %>
	${Sample.add(10,20)}<br/>
	${sample.mul(10,20)}<br/>
</body>
</html>