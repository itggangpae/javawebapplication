<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application 기본 객체 속성 보기</title>
</head>
<body>
	<%
	Enumeration<String>attrEnum = application.getAttributeNames();
	while( attrEnum.hasMoreElements() ) {
		String name = (String)attrEnum.nextElement();
		Object value = application.getAttribute(name);
%>
	application 속성 :
	<b><%= name %></b> =
	<%= value %>
	<br>
	<%
	}
%>
</body>
</html>
