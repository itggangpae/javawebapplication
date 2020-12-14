package ex13;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.part")
//파일을 업로드할 실제 디렉토리를 절대 경로로 설정
@MultipartConfig(
		location = "/Users/munseokpark/Documents/data"
		)
public class PartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PartService partService;

	public PartController() {
		super();
		partService = PartServiceImpl.sharedInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/ex13/upload.part") && request.getMethod().equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/partform.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/ex13/upload.part") && request.getMethod().equals("POST")) {
			Map<String, Object>map = partService.fileUpload(request);
			request.getSession().setAttribute("map", map);
			response.sendRedirect("uploadresult.part");
		}
		else if (command.equals("/ex13/uploadresult.part") && request.getMethod().equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/uploadresult.jsp");
			dispatcher.forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}