<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Session Login</title>
<%
	String id = (String) session.getAttribute("id");
%>
</head>
<body>
	<%
		if (id == null) {
	%>
	<form action="loginprocess.jsp" method="post">
		<table border=0 width=400 height=100>
			<tr bgcolor="yellow">
				<td align=right><font size=2>아이디 :</font></td>
				<td><input type="text" name="id" size=10></td>
			</tr>
			<tr bgcolor="yellow">
				<td align=right><font size=2>비밀번호 :</font></td>
				<td><input type="password" name="pass" size=12></td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan=2 align=center><input type="submit" value="로그인"
					style="width: 60pt" size="10"> <input type="reset"
					value="다시 작성" style="width: 60pt" size="10"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	<%=id%>님 로그인하셨습니다.
	<br />
	<a href="sessionlogout.jsp">로그 아웃</a>
	<%
		}
	%>
</body>
</html>
