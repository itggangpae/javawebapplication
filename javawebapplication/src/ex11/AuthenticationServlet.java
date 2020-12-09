package ex11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/authentication/*")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String routePath = requestURI.substring(contextPath.length()+15);
		
		String method = request.getMethod();
		System.out.println(routePath);
		System.out.println(method);
		
		RequestDispatcher dispatcher = null;
		
		
		switch(routePath) {
		case "/login":
			if(method.equals("GET")) {
				dispatcher = request.getRequestDispatcher("../ex11/login.jsp");
				dispatcher.forward(request, response);
			}else {
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				String nickname = "관리자";
				
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("nickname", nickname);
				
				//response.sendRedirect(contextPath + "/authentication/main");
				String path = (String)request.getSession().getAttribute("path");
				if(path == null) {
					response.sendRedirect(contextPath + "/authentication/main");
				}else {
					request.getSession().setAttribute("pass", null);
					response.sendRedirect(path);
				}
			}
			break;
		case "/logout":
			request.getSession().invalidate();
			response.sendRedirect(contextPath + "/authentication/main");
			break;
		case "/main":
			dispatcher = request.getRequestDispatcher("../ex11/main.jsp");
			dispatcher.forward(request, response);
			break;
		case "/write":
			dispatcher = request.getRequestDispatcher("../ex11/write.jsp");
			dispatcher.forward(request, response);
			break;
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
