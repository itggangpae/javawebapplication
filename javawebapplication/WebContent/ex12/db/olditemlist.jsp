<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 목록 보기</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>코드</th>
			<th>카테고리</th>
			<th>프로그램</th>
		</tr>
		<c:forEach var="item" items="${result}">
			<tr>
				<td>${item.code}</td>
				<td>${item.category}</td>
				<!-- <td><a href="itemdetail?code=${item.code}">${item.title}</a></td> -->
				<td><a href="itemdetail/${item.code}">${item.title}</a></td>
		</c:forEach>	
	</table>
</body>
</html>
