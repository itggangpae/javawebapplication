<%@tag body-content="empty" %>
<%@ tag import="java.util.*" %>
<%@ tag import="java.sql.Date" %>
<%
	Calendar cal = Calendar.getInstance();
	Date today = new Date(cal.getTimeInMillis());
%>
<%=today%>