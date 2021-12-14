<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터 수정</title>
</head>
<body>
	<h3>데이터 수정</h3>
	<form action="itemupdate" method="post">
		<p>
			코드:<input type="text" name="code" value="${result.code}"
			readonly="readonly"/>
		</p>
		<p>
			이름:<input type="text" name="title" value="${result.title}"/>
		</p>
		<p>분야:<select name="category">
				<option value="language" <c:out value=
		"${result.category=='language'?'selected':'' }"/>>프로그래밍 언어</option>
				<option value="database" <c:out value=
		"${result.category=='database'?'selected':'' }"/>>데이터베이스</option>
				<option value="os" <c:out value=
		"${result.category=='os'?'selected':'' }"/>>운영체제</option>
				<option value="etc" <c:out value=
		"${result.category=='etc'?'selected':'' }"/>>기타</option>
			</select>
		</p>
		<p>설명:
		<textarea name="description" rows="5" cols="20">${result.description}</textarea>
		</p>
		<p>
			<input type="submit" value="데이터 수정" />
		</p>
	</form>
</body>
</html>
		