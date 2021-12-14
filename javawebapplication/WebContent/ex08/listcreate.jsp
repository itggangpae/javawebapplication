<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*" %>
<%
    ArrayList <String> friends = new ArrayList<String>();
	friends.add("최향남");
	friends.add("이종범");
	friends.add("이대진");
    request.setAttribute("FRIENDS", friends);
    RequestDispatcher dispatcher = request.getRequestDispatcher("arrayresult.jsp");
    dispatcher.forward(request, response); 
%>
