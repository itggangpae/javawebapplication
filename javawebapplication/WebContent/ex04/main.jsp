<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jspinclude</title>
</head>
<body>
	main.jsp에서 생성한 내용.
	<jsp:include page="sub.jsp" flush="true" />
	include 이후의 내용.
</body>
</html>
