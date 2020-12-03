<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	$(window).bind("beforeunload", function() {
		$.ajax({
			url : 'logout.jsp'
		});
	});
		$(document).keydown(function(e) {
		alert(e.which);
		if (e.which == 116)
			return false;
	});
</script>
</head>
<body>
	<%
		session.setAttribute("test", "sample");
	%>
</body>
</html>

