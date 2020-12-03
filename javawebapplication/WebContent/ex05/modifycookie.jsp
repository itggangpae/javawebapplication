<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키의 값 변경</title>
</head>
<body>
	<%@ page import="java.net.*"%>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					Cookie cookie = new Cookie("name", URLEncoder.encode(
							"JSP프로그래밍", "UTF-8"));
					response.addCookie(cookie);
				}
			}
		}
	cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
	%>
	<%=cookies[i].getName()%>
	=
	<%=URLDecoder.decode(cookies[i].getValue(), "UTF-8")%><br>
	<%
		}
		} else {
	%>
	쿠키가 존재하지 않습니다.
	<%
		}
	%>

name 쿠키의 값을 변경합니다.
<br/><a href="viewcookies.jsp">쿠키 확인</a>
</body>
</html>
		