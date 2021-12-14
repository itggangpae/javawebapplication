package ex12;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/ex12/connect", "/ex12/itemlist" , "/ex12/itemdetail/*" , "/ex12/iteminsert", "/ex12/itemupdate/*", "/ex12/itemdelete/*", "/ex12/getlist" })
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemService itemService;

       
    public ItemController() {
        super();
        itemService = ItemServiceImpl.getInstance();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		if (command.equals("/ex12/connect")) {
			boolean r = itemService.connect();
			request.setAttribute("result", r);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/connect.jsp");
			dispatcher.forward(request, response);
		}
		/*
		else if (command.equals("/ex12/itemlist")) {
			List<Item> list = itemService.itemList();
			request.setAttribute("result", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/itemlist.jsp");
			dispatcher.forward(request, response);
		}
		*/
		/*
		else if (command.equals("/ex12/itemlist")) {
			itemService.itemList(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/itemlist.jsp");
			dispatcher.forward(request, response);
		} 
		*/
		
		else if (command.equals("/ex12/itemlist")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/itemlist.jsp");
			dispatcher.forward(request, response);
		} 
		else if (command.equals("/ex12/getlist")) {
			itemService.itemList(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/getlist.jsp");
			dispatcher.forward(request, response);
		} 


		/*
		else if (command.equals("/itemdetail")) {
			Item item = itemService.itemDetail(request);
			request.setAttribute("result", item);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/itemdetail.jsp");
			dispatcher.forward(request, response);
		}
		*/

		else if (command.indexOf("/itemdetail") >= 0) {
			Item item = itemService.itemDetail(request);
			request.setAttribute("result", item);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../db/itemdetail.jsp");
			dispatcher.forward(request, response);
		}

		else if(command.equals("/ex12/iteminsert") && request.getMethod().equals("GET")){
			//데이터 삽입 페이지로 포워딩
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("db/iteminsert.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex12/iteminsert") && request.getMethod().equals("POST")) {
			// 데이터베이스에 삽입, 삭제, 갱신 작업을 수행하고 나면
			// 리다이렉트 해야 합니다.
			// 포워딩 하면 새로고침을 했을 때 작업이 다시 수행됩니다.

			// 데이터 삽입 작업을 수행
			int r = itemService.itemInsert(request);

			// 삽입에 성공하면
			if (r == 1) {
				// 데이터 전체보기로 리다이렉트
				response.sendRedirect("itemlist");
			} else {
				// 데이터 입력하기 화면으로 리다이렉트
				response.sendRedirect("iteminsert");
			}
		}
		/*
		else if (command.equals("/ex12/itemupdate") && request.getMethod().equals("GET")) {
			Item item = itemService.itemDetail(request);
			request.setAttribute("result", item);
			RequestDispatcher dispatcher = request.getRequestDispatcher("db/itemupdate.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.equals("/ex12/itemupdate") && request.getMethod().equals("POST")) {
			// 데이터 수정 작업을 수행
			itemService.itemUpdate(request);
			response.sendRedirect("itemlist");
		}
		else if (command.equals("/ex12/itemdelete")) {
			// 데이터 수정 작업을 수행
			itemService.itemDelete(request);
			response.sendRedirect("itemlist");
		}
		*/
		
		else if (command.indexOf("/ex12/itemupdate") >= 0 && request.getMethod().equals("GET")) {
			Item item = itemService.itemDetail(request);
			request.setAttribute("result", item);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../db/itemupdate.jsp");
			dispatcher.forward(request, response);
		}
		else if (command.indexOf("/ex12/itemupdate") >= 0 && request.getMethod().equals("POST")) {
			// 데이터 수정 작업을 수행
			itemService.itemUpdate(request);
			response.sendRedirect("../itemlist");
		}
		else if (command.indexOf("/ex12/itemdelete") >= 0) {
			// 데이터 수정 작업을 수행
			itemService.itemDelete(request);
			response.sendRedirect("../itemlist");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
	
