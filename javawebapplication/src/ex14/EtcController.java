package ex14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//자신의 디렉토리 경로로 설정
@MultipartConfig(
		location = "/Users/munseokpark/Documents/data"
		)
@WebServlet({ "/ex14/mail", "/ex14/proxy", "/ex14/push"})
public class EtcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtcService etcService;

	public EtcController() {
		super();
		etcService = EtcServiceImpl.sharedInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String method = request.getMethod();
		System.out.println(command);
		if(command.equals("/ex14/mail") && method.equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/mailform.jsp");
			dispatcher.forward(request, response);
		}	
		else if(command.equals("/ex14/mail") && method.equals("POST")) {
			boolean r = etcService.mailSend(request);
			String msg = "";
			if(r == true) {
				msg = "메일 보내기에 성공하셨습니다.";
			}else {
				msg = "메일 보내기에 실패하셨습니다.";
			}
			request.getSession().setAttribute("msg", msg);
			response.sendRedirect("mailresult.do");
		}else if(command.equals("/ex14/mailresult.do") && method.equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/mailresult.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/ex14/proxy")){
			String result = etcService.download(request, response);
			System.out.println(result);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/proxy.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex14/push")) {
			etcService.push(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
