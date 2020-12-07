<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>입력 화면</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="${pageContext.request.contextPath}/bbsProcess" method="get">
		이름: <input type="text" name="name"><br /> 
		제목: <input 	type="text" name="title"><br /> 
		<span>내용:</span> <textarea cols="30" rows="5" name="content"></textarea>
		<br /> <input type="submit" value='저장'>
	</form>
</body>
</html>