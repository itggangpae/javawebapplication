package ex12;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	private UserServiceImpl() {
		userDao = UserDao.getInstance();
	}

	private static UserService userService;

	public static UserService getInstance() {
		if (userService == null)
			userService = new UserServiceImpl();
		return userService;
	}

	@Override
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		return userDao.idCheck(id);
	}

	@Override
	public String nicknameCheck(HttpServletRequest request) {
		String nickname = request.getParameter("nickname");
		return userDao.nicknameCheck(nickname);
	}
	
	@Override
	public int userRegister(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String passwordHashed = BCrypt.hashpw(pw, BCrypt.gensalt(10));
		String nickname = request.getParameter("nickname");
		
		User user = new User();
		user.setId(id);
		user.setPw(passwordHashed);
		user.setNickname(nickname);
		
		return userDao.userRegister(user);
	}	

	
	@Override
	public User login(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		User user = new User();
		user.setId(id);
		User checkUser = userDao.login(user);
		if(checkUser != null){
			boolean isValidPassword = BCrypt.checkpw(pw, checkUser.getPw());
			if(isValidPassword == false){
				checkUser=null;
			}
		}
		return checkUser;
	}
}

