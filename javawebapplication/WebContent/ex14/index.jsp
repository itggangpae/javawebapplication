<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/html4/loose.dtd>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 기타</title>
</head>
<body>
	<input type="button" onclick="location.href='mail'" value="메일보내기" />
	<input type="button" value="proxy 가져오기" onclick="proxy()">
	<input type="button" value="웹 푸시 시작" onclick="pushStart()">
	<br /> 메시지:
	<span id="disp"></span>

닉네임<input type="text" 
		id="nickname" size="20"/><br />
	보내는 메시지<input type="text"
		id="message" size="50" />
	<input type="button" value="보내기"
		id="sendbtn" /><br />
	받은 메시지<textarea id="disp" 
		rows="20" cols="80"></textarea>
		
</body>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	function proxy() {
		$
				.ajax({
					url : "proxy",
					data : {
						addr : 'http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnId=108'
					},
					dataType : 'xml',
					success : function(data) {
						var cities = $(data).find('city');
						$(data).find('data').each(
								function(index, item) {
									var output = '';
									if (index % 6 == 0) {
										output += '<div>';
										output += '<h2>'
												+ $(cities[index / 6]).text()
												+ '</h2>';
									}
									output += '<span>'
											+ $(this).find('tmEf').text()
											+ '</span>';
									output += ':<span>'
											+ $(this).find('wf').text()
											+ '</span><br/>';
									if (index % 6 == 0) {
										output += '</div>';
									}

									// 출력합니다.
									$('body').html($('body').html() + output);
								})
					}
				})
	}

	function pushStart() {
		var eventSource = new EventSource("push");
		eventSource.onmessage = function(event) {
			document.getElementById('disp').innerHTML = event.data;
		};
	}

	//DOM 객체 찾아오기
	var nickname = 
		document.getElementById("nickname");
	var message = 
		document.getElementById("message");
	var sendbtn = 
		document.getElementById("sendbtn");
	var disp = 
		document.getElementById("disp");
	//웹 소켓 객체 생성
	var webSocket = new WebSocket(
		"ws://localhost:9000/javawebapplication/chat");
	
	//연결되었을 때 수행할 내용
	webSocket.addEventListener(
		"open", function(event){
		//채팅은 새로운 메시지를 위에 출력	
		//disp.value = "접속에 성공\n" + disp.value;
		webSocket.send(nickname.value + "님 입장");
	});
	
	//메시지가 온 경우
	webSocket.addEventListener(
		"message", function(event){
		//채팅은 새로운 메시지를 위에 출력	
		disp.value = 
			event.data + "\n" + disp.value; 
	});
	
	//버튼 눌렀을 때 메시지 보내기
	sendbtn.addEventListener(
		"click", function(event){
		var m = nickname.value + ":" + 
			message.value;
		webSocket.send(m);
		message.value = '';
	});
	
	message.addEventListener(
			"keydown", function(event){
		var e = event || window.event;
		var keycode = ('which' in e) 
			? e.which : e.keyCode;
		if(keycode == 13){
			var m = nickname.value + ":" + 
				message.value;
			webSocket.send(m);
			message.value = '';
		}
	});
	
	
</script>
</html>

