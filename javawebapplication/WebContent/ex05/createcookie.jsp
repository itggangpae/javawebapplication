<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%
	Cookie cookie = new Cookie("name", URLEncoder.encode("박문석", "UTF-8"));
	response.addCookie(cookie);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 생성</title>
<script>
	function modify(){
		location.href="modifycookie.jsp"
	}
	function deleteCookie(){
		window.open("deletecookie.jsp","", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=no" )
	}
</script>
</head>
<body>
	<%= cookie.getName() %>
	쿠키의 값 = "<%= cookie.getValue() %>"
	<br /><br />
	<a href="viewcookies.jsp">쿠키 읽기</a>
	<br /><br />
	<input type="button" value="쿠키 변경" onclick="modify()">
	<input type="button" value="쿠키 삭제" onclick="deleteCookie()">
</body>
</html>
