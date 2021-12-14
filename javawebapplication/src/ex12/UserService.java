package ex12;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	public String idCheck(HttpServletRequest request);
	public String nicknameCheck(HttpServletRequest request);
	public int userRegister(HttpServletRequest request);
	public User login(HttpServletRequest request);
}
