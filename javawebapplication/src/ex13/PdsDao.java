package ex13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PdsDao {
	DataSource ds;

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	public static PdsDao pdsDao;
	private PdsDao() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/DBConn");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static PdsDao sharedInstance() {
		if (pdsDao == null)
			pdsDao = new PdsDao();
		return pdsDao;
	}
	
	public boolean connect() {
		boolean result = false;
		try {
			con = ds.getConnection();
			result = true;
		} catch (Exception e) {
			System.out.println("연결 실패:" + e.getMessage());
		}
		return result;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}
	public int maxId() {
		int num = 0;
		sql = "select max(pdsid) from pds";
		connect();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("데이터 가져오기 실패:" + e.getMessage());
		}
		close();
		return num;
	}
	public void insertItem(Pds pds) {
		connect();
		try {
			sql = "insert into pds values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pds.getId());
			pstmt.setString(2, pds.getFileName());
			pstmt.setLong(3, pds.getFileSize());
			pstmt.setString(4, pds.getDescription());
			int row = pstmt.executeUpdate();
			System.out.println("row:" + row);
		} catch (Exception e) {
			System.out.println("데이터 삽입 실패:" + e.getMessage());
			e.printStackTrace();
		}
		close();
	}
	public List<Pds> getItem() {
		List<Pds> list = new ArrayList<Pds>();
		sql = "select * from pds";
		connect();
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Pds pds = new Pds();
				pds.setId(rs.getInt("pdsid"));
				pds.setFileName(rs.getString("fileName"));
				pds.setFileSize(rs.getInt("filesize"));
				pds.setDescription(rs.getString("description"));
				list.add(pds);
			}
		}
		catch (Exception e) {
			System.out.println("데이터 가져오기 실패:" + e.getMessage());
		}
		close();
		return list;
	}

}

	
