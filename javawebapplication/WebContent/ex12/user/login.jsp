<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<style>
table {
	margin-left: auto;
	margin-right: auto;
	border: 1px solid black;
	border-spacing: 10px;
}
</style>
</head>
<body>
	<div id="msg">${msg}</div>
	<form method="post">
		<table>
			<tr>
				<td colspan="2" align=center><b><font size=5>로그인 페이지</font></b></td>
			</tr>
			<tr>
				<td align="right">아이디&nbsp;</td>
				<td>&nbsp;<input type="text" name="id" required="required" /></td>
			</tr>
			<tr>
				<td align="right">비밀번호&nbsp;</td>
				<td>&nbsp;<input type="password" name="pw" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2" align=center><input type="submit" value=" 로그인 " />
					&nbsp;&nbsp; <input type="button" value="메인으로" id="mainbtn" />
					&nbsp;&nbsp; <input type="button" value="회원가입" id="joinbtn" /></td>
			</tr>
		</table>
	</form>
</body>
<script>
	document.getElementById("mainbtn").addEventListener('click', function() {
		location.href = './';
	});
	document.getElementById("joinbtn").addEventListener('click', function() {
		location.href = 'userregister';
	});
</script>
</html>
