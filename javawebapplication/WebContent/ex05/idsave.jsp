<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 스토리지 사용</title>
</head>
<body>
	<form action="login.jsp" id="loginform">
		<%
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("id")) {
			out.println("아이디:<input type='text' name='id' id='id' required='required' value='" + cookies[i].getValue() + "'/><br />");
			out.println("<input type='checkbox' name='idsave' value='check' id='idsave' checked='checked'> 아이디 저장<br /> ");
			flag = true;
			break;
				}
			}
		}
		if (flag == false) {
			out.println("아이디:<input type='text' name='id' id='id' required='required' /><br />");
			out.println("<input type='checkbox' name='idsave' value='check' id='idsave'> 아이디 저장<br /> ");

		}
		%>
		<input type="submit" value="로그인" />
	</form>

</body>
</html>
