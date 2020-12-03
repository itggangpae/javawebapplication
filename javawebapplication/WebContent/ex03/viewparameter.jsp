<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>요청 파라미터 출력</title>
</head>
<body>
	<b>request.getParameter() 메소드 사용</b>
	<br /> name 파라미터 =
	<%=request.getParameter("name")%>
	<br /> job 파라미터 =
	<%=request.getParameter("job")%>
	<p>
		<b>request.getParameterValues() 메소드 사용</b><br />
		<%
			String[] values = request.getParameterValues("sports");
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
		%>
		<%=values[i]%>
		<%
			}
			}
		%>
	</p>
</body>
</html>
	