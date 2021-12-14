package ex12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDao {
	// 데이터베이스 연결 변수
	private Connection con;

	// 싱글톤 인스턴스를 만들기 위한 코드
	private static ItemDao itemDao;

	// 생성자 - 데이터베이스 드라이버 클래스 로드
	private ItemDao() {
		try {
			// 오라클 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static ItemDao getInstance() {
		if (itemDao == null)
			itemDao = new ItemDao();
		return itemDao;
	}

	//SQL 실행을 위한 변수
	private PreparedStatement pstmt;
	//Select 구문 결과를 저장할 변수
	private ResultSet rs;

	// 데이터베이스 연결 메소드
	public boolean connect() {
		boolean r = false;
		try {
			// 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "");
			r = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}

	// 데이터베이스 자원 해제 메소드
	public void close() {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Item> itemList() {
		List<Item> list = new ArrayList<Item>();
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select * from item");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Item item = new Item();
					item.setCode(rs.getInt("code"));
					item.setTitle(rs.getString("title"));
					item.setCategory(rs.getString("category"));
					item.setDescription(rs.getString("description"));
					list.add(item);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		System.out.println(list);
		return list;
	}

	public Item itemDetail(int code) {
		Item item = null;
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select * from item where code = ?");
				pstmt.setInt(1, code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					item = new Item();
					item.setCode(rs.getInt("code"));
					item.setTitle(rs.getString("title"));
					item.setCategory(rs.getString("category"));
					item.setDescription(rs.getString("description"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return item;
	}

	//데이터 삽입을 위해서 가장 큰 code를 찾아오는 메소드
	public int maxCode(){
		int r = 0;
		try{
			connect();
			pstmt = con.prepareStatement(
					"select max(code) from item");
			rs = pstmt.executeQuery();
			if(rs.next()){
				//select 절의 첫번째 컬럼의 값을 정수로 변환해서
				//r에 대입
				r = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}

	//실제 데이터를 삽입하는 메소드
	//삽입,삭제,갱신은 영향받은 행의 개수를 리턴
	public int itemInsert(Item item){
		int r = -1;
		try{
			connect();
			pstmt = con.prepareStatement(
					"insert into item values(?,?,?,?)");
			pstmt.setInt(1, item.getCode());
			pstmt.setString(2,  item.getTitle());
			pstmt.setString(3, item.getCategory());
			pstmt.setString(4, item.getDescription());

			//삽입문장 실행
			r = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}
	
	public int itemUpdate(Item item){
		int r = -1;
		try{
			connect();
			pstmt = con.prepareStatement(
				"update item set title=?, category=?, description=? where code=?");
			pstmt.setString(1,  item.getTitle());
			pstmt.setString(2, item.getCategory());
			pstmt.setString(3, item.getDescription());
			pstmt.setInt(4, item.getCode());
			//수정문장 실행
			r = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}
	
	public int itemDelete(int code){
		int r = -1;
		try{
			connect();
			pstmt = con.prepareStatement(
				"delete from item where code=?");
			pstmt.setInt(1, code);
			//삭제문장 실행
			r = pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		close();
		return r;
	}
	
	/*
	public int getCount() {
		int cnt = 0;
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select count(*) from item");
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cnt = rs.getInt(1); 
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return cnt;
	}

	public List<Item> itemList(int pageno, int perpagecnt) {
		List<Item> list = new ArrayList<Item>();
		if (connect()) {
			try {
				pstmt = con.prepareStatement("select * from item limit ?, ?");
				pstmt.setInt(1, (pageno-1) * perpagecnt);
				pstmt.setInt(2, perpagecnt);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Item item = new Item();
					item.setCode(rs.getInt("code"));
					item.setTitle(rs.getString("title"));
					item.setCategory(rs.getString("category"));
					item.setDescription(rs.getString("description"));
					list.add(item);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return list;
	}
	*/
	
	public int getCount(Map<String, Object> map) {
		int cnt = 0;
		if (connect()) {
			try {
				String keyword = (String)map.get("keyword");
				String search = (String)map.get("search");
				if(keyword == null) {
					pstmt = con.prepareStatement("select count(*) from item");
				}else if(keyword.equals("category")) {
					pstmt = con.prepareStatement("select count(*) from item where category like ?");
					pstmt.setString(1, "%" + search + "%");;
				}else if(keyword.equals("title")) {
					pstmt = con.prepareStatement("select count(*) from item where title like ?");
					pstmt.setString(1, "%" + search + "%");
				}
				else if(keyword.equals("all")) {
					pstmt = con.prepareStatement("select * from item where category like ? or title like ?");
					pstmt.setString(1, "%" + search + "%");
					pstmt.setString(2, "%" + search + "%");
				}
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cnt = rs.getInt(1); 
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return cnt;
	}
	
	public List<Item> itemList(Map<String, Object> map) {
		List<Item> list = new ArrayList<Item>();
		if (connect()) {
			try {
				String keyword = (String)map.get("keyword");
				String search = (String)map.get("search");
				int pageno = (Integer)map.get("pageno");
				int perpagecnt = (Integer)map.get("perpagecnt");
				System.out.println(map);
				if(keyword == null) {
					pstmt = con.prepareStatement("select * from item limit ?, ?");
					pstmt.setInt(1, (pageno-1) * perpagecnt);
					pstmt.setInt(2, perpagecnt);
				}else if(keyword.equals("category")) {
					pstmt = con.prepareStatement("select * from item where category like ? limit ?, ?");
					pstmt.setString(1, "%" + search + "%");
					pstmt.setInt(2, (pageno-1) * perpagecnt);
					pstmt.setInt(3, perpagecnt);
				}
				else if(keyword.equals("title")) {
					pstmt = con.prepareStatement("select * from item where title like ? limit ?, ?");
					pstmt.setString(1, "%" + search + "%");
					pstmt.setInt(2, (pageno-1) * perpagecnt);
					pstmt.setInt(3, perpagecnt);
				}else if(keyword.equals("all")) {
					pstmt = con.prepareStatement("select * from item where category like ? or title like ? limit ?, ?");
					pstmt.setString(1, "%" + search + "%");
					pstmt.setString(2, "%" + search + "%");
					pstmt.setInt(3, (pageno-1) * perpagecnt);
					pstmt.setInt(4, perpagecnt);
				}
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Item item = new Item();
					item.setCode(rs.getInt("code"));
					item.setTitle(rs.getString("title"));
					item.setCategory(rs.getString("category"));
					item.setDescription(rs.getString("description"));
					list.add(item);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		close();
		return list;
	}
}
