<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	session.setAttribute("id",null);
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("sessionlogin.jsp");
	dispatcher.forward(request, response);
%>
