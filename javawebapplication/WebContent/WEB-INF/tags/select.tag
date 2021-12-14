<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="options" %>
<%@ attribute name="name"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name}">
	<c:forEach items="${options}" var="op">
	<option value="${op.key}">${op.value}</option>
	</c:forEach>
</select>