<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String idsave = request.getParameter("idsave");
		if(idsave == null){
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (int i = 0 ; i < cookies.length ; i++) {
					if (cookies[i].getName().equals("id")) {
						Cookie cookie = new Cookie("id", "");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}else{
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}
	%>
</body>
</html>