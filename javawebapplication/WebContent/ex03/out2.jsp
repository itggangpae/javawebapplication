<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out 객체</title>
</head>
<body>
	<% int grade = -11;
		if(grade >= 0){
	%>
	<p><%=grade %></p>
	<%} else { %>
	<p><%= grade*-1 %></p>
	<% }%>
	<% 
		if(grade >= 0)
			out.println("<p>" + grade + "</p>");
		else
			out.println("<p>" + grade*-1 + "</p>");
	%>
</body>
</html>
