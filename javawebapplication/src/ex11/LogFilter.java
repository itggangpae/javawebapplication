package ex11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */

public class LogFilter implements Filter {

	PrintWriter writer;

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		if (writer != null)
			writer.close();

	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Calendar now = new GregorianCalendar();
		writer.printf("현재일시: %TF %TT %n", now, now);
		String clientAddr = request.getRemoteAddr();
		writer.printf("클라이언트 주소: %s %n", clientAddr);
		String requestURI = ((HttpServletRequest)request).getRequestURI();
		writer.printf("요청 경로: %s %n", requestURI);
		chain.doFilter(request, response);
		writer.println("---------------------------------------------------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			//파일의 경로는 시스템에 따라 다르게 설정
			writer = new PrintWriter(new FileWriter("/Users/munseokpark/Documents/myFilter.log", true), true);
		} catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}

	}

}
