<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h3>메인 페이지</h3>
	<c:if test="${id==null}">
		<a href="${pageContext.request.contextPath}/authentication/login">로그인</a><br/>
	</c:if>
	<c:if test="${id != null}">
		${nickname}님 <a href="${pageContext.request.contextPath}/authentication/logout">로그아웃</a><br/>
	</c:if>
	<a href="${pageContext.request.contextPath}/authentication/write">글쓰기</a><br/>
</body>
</html>