package ex12;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	//데이터베이스 연결 변수
	private Connection con;
	//SQL 실행을 위한 변수
	private PreparedStatement pstmt;
	//Select 구문 결과를 저장할 변수
	private ResultSet rs;

	//생성자 - 데이터베이스 드라이버 클래스 로드
	private UserDao(){
		/*
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
	}

	private static UserDao userDao;

	public static UserDao getInstance(){
		if(userDao == null)
			userDao = new UserDao();
		return userDao;
	}

	// 데이터베이스 연결 메소드
	/*
	private boolean connect() {
		boolean r = false;
		try {
			// 데이터베이스 연결
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "");
			r = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	*/
	
	// 데이터베이스 연결 메소드
	private boolean connect() {
		boolean r = false;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			con = ds.getConnection();
			r = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			r = false;
		}
		return r;
	}
	
	// 데이터베이스 자원 해제 메소드
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String idCheck(String id) {
		String account = null;
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select id from userinfo where id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					account = rs.getString("id");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return account;
	}
	public String nicknameCheck(String nickname) {
		String account = null;
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select nickname from userinfo where nickname = ?");
				pstmt.setString(1, nickname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					account = rs.getString("nickname");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return account;
	}
	
	/*
	public int userRegister(User user){
		int r  = -1;
		try{
			connect();
			pstmt = con.prepareStatement("insert into userinfo values(?,?,?)");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getNickname());
			r = pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}
	*/
	
	public int userRegister(User user){
		int r  = -1;
		try{
			connect();
			String query = "{call INSERT_USER(?,?,?)}";
			CallableStatement call = con.prepareCall(query);
			call.setString(1, user.getId());
			call.setString(2, user.getPw());
			call.setString(3, user.getNickname());
			r = call.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}

	public User login(User user){
		User login = null;
		try{
			connect();
			pstmt = con.prepareStatement("select id, pw, nickname from userinfo where id=?");
			pstmt.setString(1, user.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				login = new User();
				login.setId(rs.getString("id"));
				login.setPw(rs.getString("pw"));
				login.setNickname(rs.getString("nickname"));
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return login;
	}			
}

