<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CODE" value="80012" scope="request" /> 
<c:set var="NAME" value="교재" scope="request" /> 
<c:set var="PRICE" value="15000" scope="request" />
<jsp:forward page="productview.jsp" />
