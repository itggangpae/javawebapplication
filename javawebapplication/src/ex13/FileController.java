package ex13;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FileController", urlPatterns = { "*.file" })
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService;

	public FileController() {
		super();
		fileService = FileServiceImpl.sharedInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/ex13/form.file") && request.getMethod().equals("GET")) 		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/fileuploadform.jsp");
			dispatcher.forward(request, response);
		} 
		/*
		else if (command.equals("/ex13/form.file") && request.getMethod().equals("POST")) {
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");
			InputStream is = request.getInputStream();
			out.println('[');
			out.println(new String(request.getContentType().getBytes()));
			out.println(']');
			out.println("<br/>");
			int data = -1;
			while ( (data = is.read()) != -1) {
				out.println((char)data);
			}
		}
		*/
		else if (command.equals("/ex13/form.file") && request.getMethod().equals("POST")) {
			Map<String, Object>map = fileService.fileUpload(request);
			request.getSession().setAttribute("map", map);
			response.sendRedirect("result.file");
		}
		else if (command.equals("/ex13/result.file") && request.getMethod().equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/result.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex13/upload.file") && request.getMethod().equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/uploadform.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/ex13/upload.file") && request.getMethod().equals("POST")){
			fileService.uploadFile(request);	
			response.sendRedirect("uploaded.file");
		}else if (command.equals("/ex13/uploaded.file") && request.getMethod().equals("GET")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/uploaded.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex13/list.file") && request.getMethod().equals("GET")) {
			List<Pds> list = fileService.getList(request);
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/ex13/download.file") && request.getMethod().equals("GET")){
			fileService.download(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
