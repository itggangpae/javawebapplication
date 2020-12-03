<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>파일 등록</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		파일: 
		<input type="file" name="file" required="required" id="file" /> <br /> 
		설명: <input type="text" name="description" /> <br /> 
		<input type="submit" value="업로드" /> <br />
		<a href="list.file">목록 보기</a>
	</form>
</body>
</html>