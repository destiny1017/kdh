package insert.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DataDAO {
	
	ArrayList<DataDTO> books = new ArrayList<>();
	
	public void insertStock(String book) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "update books_stock set stock = ? where isbn = ?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			String[] split = book.split("/");
			int sum = Integer.parseInt(split[1]) + Integer.parseInt(split[2]);
			pstmt.setInt(1, sum);
			pstmt.setString(2, split[0]);
			pstmt.executeUpdate();
		
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
		books = new ArrayList<>();
		
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
	
	
	public ArrayList<DataDTO> searchBook(String title) {
		
		ArrayList<DataDTO> booksRs = new ArrayList<>();
		
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().indexOf(title) != -1) {
				booksRs.add(books.get(i));
			}
		}	
		return booksRs;
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
	
//	public ArrayList<DataDTO> searchBook(String title) {
//		
//		PreparedStatement pstmt = null;
//		Connection conn = null;
//		ResultSet rs = null;
//		
//		String url = "jdbc:mysql://localhost:3306/erp";
//		String uid = "root";
//		String upw = "1234";
//		String sql = "select * from books where title like '%" + title + "%'";
//		
//		
//		ArrayList<DataDTO> books = new ArrayList<>();
//		
//		try {
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(url, uid, upw);
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				books.add(new DataDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"), 
//						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return books;
//	}
}
