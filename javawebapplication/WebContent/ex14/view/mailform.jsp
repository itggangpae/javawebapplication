<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>자바 메일 보내기 폼</title>
<style>
table {
	width: 450px;
	margin: auto;
}

h1 {
	text-align: center;
}

td {
	border: 1px dotted gray;
}

.title {
	text-align: right;
}
</style>
</head>
<body>
	<form name="form1" method="post" enctype="multipart/form-data">
		<h1>자바메일 보내기</h1>
		<table>
			<tr>
				<td class="title">보내는 사람</td>
				<td><input type="text" name="sender"
					value="ggangpae11@naver.com" readonly="readonly"></td>
			</tr>
			<tr>
				<td class="title">받는 사람</td>
				<td><input type="text" name="receiver" required="required"></td>
			</tr>
			<tr>
				<td class="title">제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td class="title">내용</td>
				<td><textarea name="content" cols="40" rows="20"></textarea></td>
			</tr>
			
			<tr>
				<td class="title">첨부 파일</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="메일전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>
			