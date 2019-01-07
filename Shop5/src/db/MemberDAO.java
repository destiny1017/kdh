package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;
import com.sun.istack.internal.Pool;

public class MemberDAO {

	DBConnectionMgr pool;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MemberDAO() {
		pool = DBConnectionMgr.getInstance();
	}

	public void insertMember(MemberDTO member) {

		String sql = "insert into member values (?,?,?,?)";

		try {
			conn = pool.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		pool.freeConnection(conn, pstmt);
	}

	public void insert(MemberDTO member) {

		PreparedStatement pstmt = null;
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/bigdata";
		String uid = "root";
		String upw = "1234";
		String sql = "insert into member values(?,?,?,?)";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {

		PreparedStatement pstmt = null;
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/bigdata";
		String uid = "root";
		String upw = "1234";
		String sql = "delete from member where id='" + id + "'";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login(String id, String pw) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/bigdata";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from member where id = '" + id + "' && pw = '" + pw + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
	public ArrayList<MemberDTO> select() {
		
		ArrayList<MemberDTO> member = new ArrayList<>();
	
		String sql = "select * from member";
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.add(new MemberDTO(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("tel"),
						rs.getString("address")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		pool.freeConnection(conn, pstmt, rs);
		return member;
	}
}
