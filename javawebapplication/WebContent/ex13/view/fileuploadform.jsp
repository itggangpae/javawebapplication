<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>FileUpload Form</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<td colspan=2 align=center><h3>파일 업로드 폼</h3></td>
			<tr>
				<td>올린 사람 :</td>
				<td><input type="text" name="name"></td>
			</tr>
						<tr>
				<td>제목 :</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>파일명 :</td>
				<td><input type="file" name="fileName1"></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>
			