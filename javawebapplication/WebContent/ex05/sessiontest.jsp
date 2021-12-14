<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg;
	if (session.getAttribute("id")!=null){
		msg=(String)session.getAttribute("id");
	}else{
		msg="세션 값 없음.";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Session Test</title>
</head>
<body>
<h2>세션 테스트</h2>
<a href="sessionsave.jsp"> 세션에 저장 </a><br />
<a href="sessiondelete.jsp"> 세션에서 삭제 </a><br />
<a href="sessioninit.jsp"> 세션 초기화 </a><br />
<h3><%=msg %></h3>
</body>
</html>
