<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td colspan="3" align="center">
			<h3>파일 목록</h3>
			[<a href="./">메인</a>]
			</td>
		</tr>	
		<tr>
			<td>번호</td>
			<td>파일명</td>
			<td>파일크기</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.id}</td>
				<td>${item.fileSize}</td>
				<td><a href="download.file?filename=${item.fileName}">${item.fileName}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
		