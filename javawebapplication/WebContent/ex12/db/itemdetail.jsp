<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>항목</td>
			<td>${result.title}</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${result.description}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			[<a href="${pageContext.request.contextPath}/ex12/itemupdate/${result.code}">수정하기</a>]&nbsp; [
			<a href="${pageContext.request.contextPath}/ex12/itemdelete/${result.code}">삭제하기</a>]&nbsp;

			</td>
		</tr>
	</table>
</body>
</html>
