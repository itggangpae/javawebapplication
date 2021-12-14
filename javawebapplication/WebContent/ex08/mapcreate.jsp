<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*" %>
<%
HashMap<String, String> map = new HashMap<String, String>();
map.put("Park", "목동");
map.put("Jasica", "크라이스 처치");
map.put("Susan", "시드니");
request.setAttribute("ADDRESS", map);
RequestDispatcher dispatcher = request.getRequestDispatcher("mapview.jsp?NAME=Park");
dispatcher.forward(request, response); 
%>
