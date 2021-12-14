package ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1
 */
//@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;

	public void init(){
		//데이터베이스 연결
		try {
			Class.forName(getInitParameter("CLASS_NAME"));
			conn = DriverManager.getConnection(getInitParameter("DB_NAME"),"system","choongang");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.resetBuffer(); 
		response.setContentType("text/html;charset=UTF-8"); 
		out.println("<script language='javascript'>"); 
		out.print("alert(\""); 
		String message;
		if(conn!= null)
			message = "success";
		else
			message = "fail";
		out.print(message); 
		out.println("\");"); 
		out.println("</script>"); 
		response.flushBuffer(); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
