<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일에 기록</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		String msg = ip + "에서 " + name + "을 전송";
		PrintWriter writer = null;
		String path = application.getRealPath("/ex03");
		boolean result = false;
		try{
			writer = new PrintWriter(
					new BufferedWriter(
					new FileWriter(path + "/serverlog.txt", true)));
			System.out.println(writer.toString());
			writer.println(msg);
			//out.println("저장 성공");
			result = true;
		}
		
		catch(Exception e){
			out.println("저장 실패");
		}
		finally{
			try{
				writer.close();
			}
			catch(Exception e){}
		}
		response.sendRedirect("saveresult.jsp?result=" + result);
	%>
</body>
</html>
		