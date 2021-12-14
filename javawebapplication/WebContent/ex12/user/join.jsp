<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
table {
	margin-left: auto;
	margin-right: auto;
	border: 1px solid black;
	border-spacing: 10px;
}

input {
	line-height: 2em;
	font-size: 16px;
}

.btn {
	width: 70pt;
	height: 30pt;
}

span {
	color: red;
}
</style>
</head>
<body>
	<form id="joinForm" action="userregister" method="post">
		<table>
			<tr>
				<td colspan="2" align="center">
					<h2>회원 가입</h2>
				</td>
			</tr>
			<tr>
				<td align='right'>아이디</td>
				<td><input type="text" name="id" id="id" size="20"
					required="required" placeholder="아이디를 입력하세요" />
					<div id="idDiv"></div></td>
			</tr>
			<tr>
				<td align='right'>비밀번호</td>
				<td><input type="password" name="pw" id="pw" size="20"
					required="required" placeholder="비밀번호를 입력하세요" /></td>
			</tr>
			<tr>
				<td align='right'>별명</td>
				<td><input type="text" name="nickname" id="nickname" size="20"
					required="required" placeholder="별명을 입력하세요" />
					<div id="nicknameDiv"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="메인으로" id="mainbtn" class="btn" /> <input type="submit"
					value="회원가입" class="btn" /> <input type="reset" value="작성취소"
					class="btn" /></td>
			</tr>
		</table>
	</form>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	document.getElementById("mainbtn").addEventListener('click', function() {
		location.href = './';
	});
	
	var idCheck = "false";
	//id 입력란에서 포커스가 떠나면 호출되는 함수를 설정
	document.getElementById("id").addEventListener('focusout', function() {
		var sid = document.getElementById("id").value;
		//sid의 값이 있을 때만 수행
		if (sid != null && sid.length != 0) {
			$.ajax({
				url : 'idcheck?id=' + sid,
				dataType : 'json',
				success : function(data) {
					if (data.result == true) {
					document.getElementById("idDiv").innerHTML="사용 가능한 아이디";
					document.getElementById("idDiv").style.color="blue";
					idCheck = "true";
					}
					else {
						document.getElementById("idDiv").innerHTML="사용 불가능한 아이디";
						document.getElementById("idDiv").style.color="red";
						idCheck = "false";
					}
				}
			})
		}
	})
	
	var nicknameCheck = "false";
	//nickname 입력란에서 포커스가 떠나면 호출되는 함수를 설정
	document.getElementById("nickname").addEventListener('focusout', function() {
		var nickname = document.getElementById("nickname").value;
		alert(nickname);
		//sid의 값이 있을 때만 수행
		if (nickname != null && nickname.length != 0) {
			$.ajax({
				url : 'nicknamecheck',
				dataType : 'json',
				data:{'nickname':nickname},
				success : function(data) {
					if (data.result == true) {
					document.getElementById("nicknameDiv").innerHTML="사용 가능한 별명";
					document.getElementById("nicknameDiv").style.color="blue";
					nicknameCheck = "true";
					}
					else {
						document.getElementById("nicknameDiv").innerHTML="사용 불가능한 별명";
						document.getElementById("nicknameDiv").style.color="red";
						nicknameCheck = "false";
					}
				}
			})
		}
	})
	
	document.getElementById("joinForm").addEventListener('submit', function() {
			if (idCheck == "true") {
				document.getElementById("idDiv").innerHTML="";
			} else {
				document.getElementById("idDiv").innerHTML="아이디 중복 체크를 하세요";
				document.getElementById("idDiv").style.color="red";
				event.preventDefault();
			}
			if (nicknameCheck == "true") {
				document.getElementById("nicknameDiv").innerHTML="";
			} else {
				document.getElementById("nicknameDiv").innerHTML="별명 중복 체크를 하세요";
				document.getElementById("nicknameDiv").style.color="red";
				event.preventDefault();
			}
	})
							

</script>
</html>
