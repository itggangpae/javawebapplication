<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스</title>
</head>
<body>
	<p>
		<a href="connect">데이터베이스 연결</a>
	</p>
	<p>
		<a href="itemlist">전체 데이터 조회</a>
	</p>
	<p>
		<a href="iteminsert">데이터 삽입</a>
	</p>
	<p>
		<a href="userregister">회원가입</a>
	</p>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${user == null }">
		<p>
			<a href="login">로그인</a>
		</p>
	</c:if>
	<c:if test="${user != null }">
		<p>${user.nickname}님환영합니다.</p>
		<p>
			<a href="logout">로그아웃</a>
		</p>
	</c:if>
	
</body>
</html>