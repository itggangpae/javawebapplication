<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>익스프레션 언어 연산자</title>
</head>
<body>
	${param.NUM1}을 ${param.NUM2}로 나눈 몫은? ${param.NUM1 div param.NUM2}
	<br /> 나머지는? ${param.NUM1 mod param.NUM2}
	<br />
	<br /> 둘 다 양수입니까? ${(param.NUM1 gt 0) and (param.NUM2 gt 0)}
	<br />
</body>
</html>