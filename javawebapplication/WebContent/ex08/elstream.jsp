<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@ page import = "ex08.*" %>
<%@ page import = "java.util.*" %>
<%
	List<Student>list = new ArrayList<Student>();
	list.add(new Student("김좌진", 90));
	list.add(new Student("윤동주", 88));
	list.add(new Student("남자현", 83));
	list.add(new Student("홍범도", 97));
	list.add(new Student("유관순", 86));
	request.setAttribute("data", list);
%>
 데이터 개수:${data.stream().count()}
<br />score 평균:${data.stream().map(n->n.score).average().get()}
</body>
</html>
