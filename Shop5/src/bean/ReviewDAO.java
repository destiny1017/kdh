package bean;

import java.sql.*;

public class ReviewDAO {
	
	public void insert(ReviewDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into review value(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getContent());
		ps.setString(5, dto.getpId());
		ps.executeUpdate();
		
		con.close();
		ps.close();
	}
	
	public ReviewDTO select(String pId) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from review where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pId);
		
		ResultSet rs = ps.executeQuery();
		ReviewDTO dto = null;
		while (rs.next()) {
			dto = new ReviewDTO();
			dto.setId(rs.getString(1));
			dto.setTitle(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setpId(rs.getString(5));
		}

		con.close();
		ps.close();
		rs.close();

		return dto;
	}
	
	
	
	public void update(String title, String name, String content, String pId) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update review set title = ?, name = ?, content = ? where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, name);
		ps.setString(3, content);
		ps.setString(4, pId);

		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
	public void reCheck(String pId) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update purchaselist set reCheck = ? where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "O");
		ps.setString(2, pId);
		
		ps.executeUpdate();
		
		con.close();
		ps.close();
	}
}
