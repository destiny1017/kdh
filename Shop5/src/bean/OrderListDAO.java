package bean;

import java.sql.*;

public class OrderListDAO {
	

	public void orderCheck(String pId) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update orderlist set orCheck = ? where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "O");
		ps.setString(2, pId);
		ps.executeUpdate();
		
		con.close();
		ps.close();
	}
	
	
	public void orderDelete(String pId) throws Exception {
	
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from orderlist where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pId);
		ps.executeUpdate();
		con.close();
		ps.close();
	
	}
}
