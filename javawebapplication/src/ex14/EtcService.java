package ex14;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EtcService {
	public boolean mailSend(HttpServletRequest request);
	public String download(HttpServletRequest request, HttpServletResponse response);
	public void push(HttpServletRequest request, HttpServletResponse response);


}
