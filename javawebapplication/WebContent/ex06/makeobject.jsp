<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request"
        class="ex06.MemberInfo" />
<%
	member.setId("admin");
	member.setName("박문석");
%>
<jsp:forward page="useobject.jsp" />
