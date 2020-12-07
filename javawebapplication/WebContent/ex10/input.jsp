<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Test" method="get">
		<fieldset>
			<legend>요청 처리</legend>
			이름 : <input type="text" name="name" /><br />
			 
			<br />성별<br /> 
			<input type="radio" name="gender" value="man" checked="checked"/>남자 
			<input type="radio" name="gender" value="woman" />여자 
			
			<br />좋아하는 스포츠<br /> 
			<input type="checkbox" name="sports" value="baseball" />야구 
			<input type="checkbox" name="sports" value="soccer" />축구 
			<input type="checkbox" name="sports" value="basketball" />농구 
			<input type="checkbox" name="sports" value="volleyball" />배구 
		
	<p><input type="submit" value="전송" /></p>
		</fieldset>
	</form>
</body>
</html>
		