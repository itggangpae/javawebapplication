<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 람다</title>

</head>
<body>
${fibonacci=(n)->n==1||n==2?1:fibonacci(n-1)+fibonacci(n-2);''}<br />
9번째 피보나치 수:${fibonacci(9)}
</body>
</html>