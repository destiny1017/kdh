package dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

public class StockDAO {
	
	ArrayList<StockDTO> books = new ArrayList<>();
	
	//재고입력 메서드
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
	
	//전체 도서 리스트를 불러오는 메서드
	public ArrayList<StockDTO> showStock() {
		
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
				books.add(new StockDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"), 
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("stock")));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	//도서 검색 메서드
	public ArrayList<StockDTO> searchBook(String column, String content) {
		
		ArrayList<StockDTO> booksRs = new ArrayList<>();

		for (int i = 0; i < books.size(); i++) {
			switch(column) {
			case "제목":
				if(books.get(i).getTitle().indexOf(content) != -1) {
					booksRs.add(books.get(i));
				}
				break;
			case "ISBN":
				if(books.get(i).getIsbn().indexOf(content) != -1) {
					booksRs.add(books.get(i));
				}
				break;
			case "분류":
				if(books.get(i).getClassification().indexOf(content) != -1) {
					booksRs.add(books.get(i));
				}
				break;
			case "저자":
				if(books.get(i).getWriter().indexOf(content) != -1) {
					booksRs.add(books.get(i));
				}
				break;
			case "출판사":
				if(books.get(i).getPublisher().indexOf(content) != -1) {
					booksRs.add(books.get(i));
				}
				break;
			}
		}	
		return booksRs;
	}
	
	//판매량 입력 메서드(테스트용)
	public void insertSale() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "delete from total_sale";
		String sql2 = "select books.isbn, books.classification, books_stock.stock from books, books_stock"
				+ " where books.isbn = books_stock.isbn";
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
				switch(rs.getString("classification")) {
				case "사회정치":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(5)+13));
					break;
				case "경제경영":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(4)+10));
					break;
				case "자연과학":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(5)+9));
					break;
				case "수험서":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(3)+6));
					break;
				case "예술":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(5)+7));
					break;
				case "역사":
					pstmt.setInt(2, ran.nextInt(ran.nextInt(6)+11));
					break;
				}
				
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//도서 등록 메서드
	public int addBook(StockDTO dto) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "insert into books values(?,?,?,?,?,?)";
		String sql2 = "insert into books_stock values(?,?)";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setString(1, dto.getIsbn());
			pstmt.setString(2, dto.getClassification());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getPublisher());
			pstmt.setString(5, dto.getWriter());
			pstmt.setInt(6, dto.getPrice());
			
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, dto.getIsbn());
			pstmt.setInt(2, 0);
			
			pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "이미 존재하는 ISBN입니다.");
			return 1;
		}
		
		return JOptionPane.showConfirmDialog(null, "정상적으로 등록되었습니다. 바로 입고를 진행하시겠습니까?");
	}
	
	//도서 삭제 메서드
	public void deleteBook(String isbn) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "delete from books_stock where isbn = '" + isbn + "'";
		String sql2 = "delete from books where isbn = '" + isbn + "'";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
