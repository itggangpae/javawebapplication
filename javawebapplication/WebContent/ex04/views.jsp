<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	
	if (code.equals("A")) {
		viewPageURI = "/ex04/viewmodule/a.jsp";
	} else if (code.equals("B")) {
		viewPageURI = "/ex04/viewmodule/b.jsp";
	} else if (code.equals("C")) {
		viewPageURI = "/ex04/viewmodule/c.jsp";
	}
%>
<jsp:forward page="<%= viewPageURI %>" />
