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
	
	public int[] selectGender() throws Exception {
	      String url = "jdbc:mysql://localhost:3306/shop";
	      String user = "root";
	      String password = "1234";
	      
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection(url, user, password);
	      String sql = "select * from member";
	      PreparedStatement ps = con.prepareStatement(sql);
	      int[] gender = new int[2];
	      ResultSet rs = ps.executeQuery();
	      int man =0;
	      int woman =0;
	   
	      while (rs.next()) {
	         if(rs.getString("resNum").charAt(7)=='1'||rs.getString("resNum").charAt(7)=='3') {
	            man++;
	         }else if(rs.getString("resNum").charAt(7)=='2'||rs.getString("resNum").charAt(7)=='4') {
	            woman++;
	         }
	         gender[0] = man;
	         gender[1] = woman;
	         
	      }

	      con.close();
	      ps.close();
	      rs.close();

	      return gender;
	      
	   }
	
	   public int[] selectAge() throws Exception {
	      String url = "jdbc:mysql://localhost:3306/shop";
	      String user = "root";
	      String password = "1234";
	      
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection(url, user, password);
	      String sql = "select * from member";
	      PreparedStatement ps = con.prepareStatement(sql);
	      int[] ageGroup = new int[5];
	      ResultSet rs = ps.executeQuery();
	      int teenage =0;
	      int twenties =0;
	      int thirties =0;
	      int forties =0;
	      int fifties =0;
	      
	      
	      while (rs.next()) {
	         int age=Integer.parseInt(rs.getString("resNum").substring(0, 2));
	         if(rs.getString("resNum").charAt(7)=='1'||rs.getString("resNum").charAt(7)=='2') {
	            age= 2018-(1900+age)+1;
	            System.out.println(age);
	            if(age>=0 && age<20) {
	               teenage++;
	            }else if(age>=20 && age<30) {
	               twenties++;
	            }else if(age>=30 && age<40) {
	               thirties++;
	            }else if(age>=40 && age<50) {
	               forties++;
	            }else if(age>=50 && age<60) {
	               fifties++;
	            }
	         }else if(rs.getString("resNum").charAt(7)=='3'||rs.getString("resNum").charAt(7)=='4') {
	            age= 2018-(2000+age)+1;
	            if(age>=10 && age<20) {
	               teenage++;
	            }else if(age>=20 && age<30) {
	               twenties++;
	            }else if(age>=30 && age<40) {
	               thirties++;
	            }else if(age>=40 && age<50) {
	               forties++;
	            }else if(age>=50 && age<60) {
	               fifties++;
	            }
	         }
	         ageGroup[0] = teenage;
	         ageGroup[1] = twenties;
	         ageGroup[2] = thirties;
	         ageGroup[3] = forties;
	         ageGroup[4] = fifties;
	         
	      }
	      
	      con.close();
	      ps.close();
	      rs.close();
	      
	      return ageGroup;
	      
	   }
	
}