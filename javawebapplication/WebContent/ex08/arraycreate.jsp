<%@page contentType="text/html; charset=utf-8"%>
<%
    String friends[] = new String[3];
	friends[0] = "최향남";
	friends[1] = "이대진";
	friends[2] = "이종범";
    request.setAttribute("FRIENDS", friends);
    RequestDispatcher dispatcher = request.getRequestDispatcher("arrayresult.jsp");
    dispatcher.forward(request, response); 
%>
