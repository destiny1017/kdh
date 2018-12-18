package dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDAO {
	
	ArrayList<BookTotalDTO> booksT = new ArrayList<>();
	ArrayList<BooksOrderDTO> books = new ArrayList<>();
	ArrayList<DetailDTO> booksD = new ArrayList<>();
	

	// 발주등록
	public void insert(OrderDTO dto, String date, String publisher) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String user = "root";
		String password = "1234";
		String sql1 = "select * from books_order where TS like '" + date + "%'";
		String sql2 = "insert into order_detail values(?,?,?)";
		String sql3 = "insert into books_order values(null,null,'" + publisher + "')";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			int exist = 0; //등록할 발주도서의 출판사가 존재하는지 체크. 존재하면 해당 출판사의 발주번호를 대입.
			int err = 0; //무한루프 걸렸을 시 탈출을 위한 변수
			
			do {
				// 오늘 날짜의 발주 리스트를 불러옴
				pstmt = conn.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				
				// 리스트 내에 현재 등록할 도서에 해당하는 출판사가 있으면 exist변수에 해당 발주 번호를 대입
				while (rs.next()) {
					if (rs.getString("publisher").equals(publisher)) {
						exist = rs.getInt("no");
						rs.beforeFirst();
						break;
					}
				}
				
				// 도서를 등록할 sql문 준비
				pstmt = conn.prepareStatement(sql2);
				if (exist != 0) { //출판사 존재할 시 해당 출판사의 발주번호로 발주 도서 등록
					pstmt.setInt(1, exist);
					pstmt.setString(2, dto.getIsbn());
					pstmt.setInt(3, dto.getQuantity());
					pstmt.executeUpdate();
				} else { //출판사 존재하지 않으면 발주리스트에 해당 출판사 추가
					pstmt = conn.prepareStatement(sql3);
					pstmt.executeUpdate();
				}
				
				err++;
				if(err > 10) {
					System.out.println("먼가 잘못댐");
					break;
				}
			} while (exist == 0); //출판사 존재하지 않아서 등록했으면 while문 반복

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BooksOrderDTO> booksOrderList() {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books_order";
		books = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				books.add(new BooksOrderDTO(rs.getInt("no"), rs.getString("TS"), rs.getString("publisher")));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public void deleteOrder(int no) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql1 = "delete from books_order where no = '" + no + "'";
		String sql2 = "delete from order_detail where no = '" + no + "'";
		booksD = new ArrayList<>();
		
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
	
	public ArrayList<DetailDTO> detailList(int no) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select books.isbn, books.classification, books.title, books.writer, order_detail.quantity, "
				+ "order_detail.no from books, order_detail "
				+ "where books.isbn = order_detail.isbn && order_detail.no = '" + no + "'";
		booksD = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				booksD.add(new DetailDTO(rs.getInt("no"), rs.getString("isbn"), rs.getString("classification"), 
						rs.getString("title"), rs.getString("writer"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksD;
		
	}

	// 발주 상세 항목 삭제
	public void delete(String isbn, int no) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "delete from order_detail where isbn = ? && no = ?";
		booksD = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, isbn);
			pstmt.setInt(2, no);
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//발주 상세 항목 수정
	public void modify(String isbn, int quantity, int no) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "update order_detail set quantity = ? where isbn = ? && no = ?";
		booksD = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, quantity);
			pstmt.setString(2, isbn);
			pstmt.setInt(3, no);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//재고입력 메서드
	public void insertStock(String isbn, int quantity) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		
		String sql = "update books_stock set stock = stock + ? where isbn = ?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, quantity);
			pstmt.setString(2, isbn);
			
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}