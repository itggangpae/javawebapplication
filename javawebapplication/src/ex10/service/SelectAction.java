package ex10.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("선택 액션");
	}
}

