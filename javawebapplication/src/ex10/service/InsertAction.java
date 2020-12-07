package ex10.service;

import javax.servlet.http.*;
public class InsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("삽입 액션");

	}
}
