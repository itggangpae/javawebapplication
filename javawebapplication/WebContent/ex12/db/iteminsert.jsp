<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터 삽입</title>
</head>
<body>
	<!-- title, category, description을 입력받는 폼
	title은 한 줄
	category는 language, database, os, etc 중 선택
	description은 많은 줄 입력이 가능하도록 폼을 생성 -->
	<!-- form 에 pw, file, textarea가 있으면 post
	그렇지 않으면 get 이나 post 모두 가능 -->
	<h3>데이터 삽입</h3>
	<form action="iteminsert" method="post">
		<p>
			이름:<input type="text" name="title" />
		</p>
		<p>
			분야:<select name="category">
				<option value="language">프로그래밍 언어</option>
				<option value="database">데이터베이스</option>
				<option value="os">운영체제</option>
				<option value="etc">기타</option>
			</select>
		</p>
		<p>
			설명
			<textarea name="description" rows="5" cols="20">
		</textarea>
		</p>
		<p>
			<input type="submit" value="데이터 추가" />
		</p>
	</form>
</body>
</html>
