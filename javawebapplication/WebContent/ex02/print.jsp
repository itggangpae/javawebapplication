<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex02.OOP, java.util.*, java.text.SimpleDateFormat, java.sql.Timestamp" %>
<html>
<head><title>List 출력</title></head>
<body>
<%
	List <OOP>li = new ArrayList<OOP>();
	OOP oop1 = new OOP("Encapsulation", "불필요한 내용은 숨기고 필요한 내용만 외부로 노출해서 클래스를 만드는 것");
	li.add(oop1);
	OOP oop2 = new OOP("Inheritance", "하위 클래스가 상위 클래스의 모든 것을 물려받는 것");
	li.add(oop2);
	OOP oop3 = new OOP("Polymorphism", "동일한 메시지에 대하여 다르게 반응하는 성질");
	li.add(oop3);
%>
	<h1>객체 지향의 3대 특성 - OOP</h1>
	<table border="1">
		<tr align="center">
			<th>특성</th>
			<th>내용</th>
		</tr>
		<%for(OOP oop : li){ %>
		<tr>
			<td><%=oop.getName() %></td>
			<td><%=oop.getDescription() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>