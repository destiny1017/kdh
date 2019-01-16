package bean;

import java.sql.*;
import java.util.ArrayList;

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

	public void insert2(MemberDTO member) {

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
						rs.getString("resNum"),
						rs.getString("tel"),
						rs.getString("address"),
						rs.getInt("amount")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		pool.freeConnection(conn, pstmt, rs);
		return member;
	}
	
	public ArrayList<MemberDTO> search(String id) {
		
		ArrayList<MemberDTO> member = new ArrayList<>();
		
		String sql = "select * from member where id like '%" + id + "%'";
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.add(new MemberDTO(
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("resNum"),
						rs.getString("tel"),
						rs.getString("address"),
						rs.getInt("amount")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		pool.freeConnection(conn, pstmt, rs);
		return member;
	}

	public void insert(MemberDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into member value(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getTel());
		ps.setString(5, dto.getAddress());
		ps.setString(6, dto.getResNum());
		ps.setInt(7, dto.getAmount());
		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	public MemberDTO select(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setResNum(rs.getString(4));
			dto.setTel(rs.getString(5));
			dto.setAddress(rs.getString(6));
			dto.setAmount(rs.getInt(7));
		}

		con.close();
		ps.close();
		rs.close();

		return dto;
	}
	


	public boolean idCheck(String id) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select count(id) from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
	
		ResultSet rs = ps.executeQuery();
		
		int result = 0;
		if(rs.next()) {
			result = Integer.valueOf(rs.getString(1));
		}
		con.close();
		ps.close();
		rs.close();
		
		return (result > 0) ? true : false;
	}
	
	
	public ArrayList<MemberDTO> selectinfo(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setResNum(rs.getString(4));
			dto.setTel(rs.getString(5));
			dto.setAddress(rs.getString(6));
			dto.setAmount(rs.getInt(7));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
		
	}
//	
	
	public MemberDTO selectId(String name) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setResNum(rs.getString(4));
			dto.setTel(rs.getString(5));
			dto.setAddress(rs.getString(6));
			dto.setAmount(rs.getInt(7));
			
		}
		con.close();
		ps.close();
		rs.close();
		
		return dto;
	}

	
	
//	
	public MemberDTO selectPw(String id, String tel) throws Exception {
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ? AND tel =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, tel);
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		while (rs.next()) {
			
			dto = new MemberDTO();
			dto.setId(rs.getString(1));
			dto.setPw(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setResNum(rs.getString(4));
			dto.setTel(rs.getString(5));
			dto.setAddress(rs.getString(6));
			dto.setAmount(rs.getInt(7));
			
		}
		
		con.close();
		ps.close();
		rs.close();
		return dto;
	}
	
}