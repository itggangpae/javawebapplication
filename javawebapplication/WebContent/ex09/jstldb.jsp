<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<title>JSTL sql 라이브러리 사용 예제</title>
</head>
<body>

<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver" 
				url="jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=utf8"
				user="root" 
				password="wnddkd"/>

<sql:update dataSource="${conn}">
	INSERT INTO booksinfo VALUES ('10011', '제3인류', '베르나르', 13800)
</sql:update>

<sql:query var="rs" dataSource="${conn}">
	SELECT * FROM booksinfo WHERE writer=?
	<sql:param>스탕달</sql:param>
</sql:query>
<c:forEach var="data" items="${rs.rows}">
	<c:out value="${data['code']}"/>
	<c:out value="${data['title']}"/>
	<c:out value="${data['writer']}"/>
	<c:out value="${data['price']}"/>
	<br />
</c:forEach>

</body>
</html>
