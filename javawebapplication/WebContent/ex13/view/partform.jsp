<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h1>Part 업로드 테스트</h1>
<form method="post" enctype="multipart/form-data">
	<label for = "writer">작성자 : </label>
	<input type = "text" name = "writer" id = "writer"><br />
	<label for = "partFile1">업로드 파일 : </label>
	<input type = "file" name = "partfile" id = "partfile"><br>
	<input type = "submit" value = "파일업로드"/>
</form>
</body>
</html>