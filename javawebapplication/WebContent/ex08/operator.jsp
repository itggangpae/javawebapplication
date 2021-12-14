<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>익스프레션 언어 연산자</title>
</head>
<body>
	${param.num1}을 ${param.num2}로 나눈 몫은? ${param.num1 div param.num2}
	<br /> 나머지는? ${param.num1 mod param.num2}
	<br />
	<br /> 둘 다 양수입니까? ${(param.num1 gt 0) and (param.num2 gt 0)}
	<br />
</body>
</html>