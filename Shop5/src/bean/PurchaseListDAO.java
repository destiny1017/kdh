package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PurchaseListDAO {
	
	
	public void purchaseInsert(PurchaseListDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into purchaselist value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getSizeS());
		ps.setString(4, dto.getSizeM());
		ps.setString(5, dto.getSizeL());
		ps.setString(6, dto.getSizeXL());
		ps.setString(7, dto.getPrice());
		ps.setString(8, dto.getReCheck());
		ps.setString(9, dto.getpId());
	
		ps.executeUpdate();
		
		con.close();
		ps.close();
	}
	
	public void purchaseDelete(String pId) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from purchaselist where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pId);
		ps.executeUpdate();
		con.close();
		ps.close();
	}
}
