package ex12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({"/ex12/userregister","/ex12/idcheck","/ex12/nicknamecheck", "/ex12/login", "/ex12/logout" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;

	public UserController() {
		super();
        userService = UserServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());

		String method = request.getMethod();
		HttpSession session = request.getSession();

		if (command.equals("/ex12/userregister") && method.equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/join.jsp");
			dispatcher.forward(request, response);
		} 
		else if(command.equals("/ex12/idcheck")){
			String id = userService.idCheck(request);
			if(id==null){
				request.setAttribute("id", "true");
			}
			else{
				request.setAttribute("id", "false");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/idcheck.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/ex12/nicknamecheck")){
			String nickname = userService.nicknameCheck(request);
			if(nickname==null){
				request.setAttribute("nickname", "true");
			}
			else{
				request.setAttribute("nickname", "false");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/nicknamecheck.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex12/userregister") && method.equals("POST")) {
			int r  = userService.userRegister(request);
			if(r > 0){
				response.sendRedirect("./");
			}
			else{
				response.sendRedirect("register");
			}
		}
		else if(command.equals("/ex12/login") && method.equals("GET")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
			dispatcher.forward(request, response);
		}	
		else if(command.equals("/ex12/login") && method.equals("POST")){
			User user = userService.login(request);
			if(user != null){
				request.getSession().setAttribute("user", user);
				request.getSession().removeAttribute("msg");
				response.sendRedirect("./");
			}
			else{
				request.getSession().removeAttribute("user");
				request.getSession().setAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
				response.sendRedirect("login");
			}
		}
		else if(command.equals("/ex12/logout")){
			request.getSession().invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/logout.jsp");
			dispatcher.forward(request, response);
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
