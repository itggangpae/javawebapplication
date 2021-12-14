package ex11;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper {
	HttpServletRequest request;

	public MyRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	public String getParameter(String name) {
		String str = request.getParameter(name);
		if (str == null)
			return null;
		return str.toUpperCase();
	}
	public String[] getParameterValues(String name) {
		String str[] = request.getParameterValues(name);
		if (str == null)
			return null;
		for (int cnt = 0; cnt < str.length; cnt++)
			str[cnt] = str[cnt].toUpperCase();
		return str;
	}

}
