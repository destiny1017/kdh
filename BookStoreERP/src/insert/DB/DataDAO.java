package insert.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DataDAO {
	
	public void insertStockR() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		Random ran = new Random();
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "select isbn from books";
		String sql2 = "insert into books_Stock values(?,?)";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql1);			
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql2);
			
			while(rs.next()) {
					pstmt.setString(1, rs.getString("isbn"));
					pstmt.setInt(2, ran.nextInt(21));
					pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DataDTO> showStock() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select b.*, bs.stock from books as b join books_stock as bs on b.isbn = bs.isbn";
		
		ArrayList<DataDTO> books = new ArrayList<>();
			
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				books.add(new DataDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"), 
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("stock")));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	public void insertSale() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "delete from total_sale";
		String sql2 = "select * from books_stock";
		String sql3 = "insert into total_sale values(?,?)";
		Random ran = new Random();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql3);
			
			while(rs.next()) {
				
				pstmt.setString(1, rs.getString("isbn"));
				pstmt.setInt(2, ran.nextInt(20));
				
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
