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
	
	public ArrayList<DetailDTO> detailList(int no) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select books.isbn, books.classification, books.title, books.writer, order_detail.quantity "
				+ "from books, order_detail where books.isbn = order_detail.isbn";
		booksD = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				booksD.add(new DetailDTO(rs.getString("isbn"), rs.getString("classification"), rs.getString("title"),
						rs.getString("writer"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksD;
		
	}

	// isbn 삭제
	public void delete(String isbn) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/erp";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "delete from books_order where isbn=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, isbn);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 발주리스트 전체보기
	public ArrayList<BookTotalDTO> SelectAll() {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select books.* ,books_order.no,books_order. quantity,books_order.TS "
				+ "from books_order,books where books_order. isbn=books.isbn";
		booksT = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				booksT.add(new BookTotalDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("no"),
						rs.getInt("quantity"), rs.getString("TS")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksT;
	}

	// 발주 장기재고 리스트
	public ArrayList<OrderDTO> lostList(String date) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		ArrayList<OrderDTO> lostBooks = new ArrayList<>();

		date = "20181214";

		DecimalFormat df = new DecimalFormat("00");

		int result = 1;

		String num = "1";
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books_order where TS like '2018-" + num + "%'";

		booksT = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);

			for (int i = 1; i < result; i++) {
				num = "" + df.format(i);

				sql = "select * from books_order where TS like '2018-" + num + "%'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					lostBooks.add(new OrderDTO(rs.getString("isbn"), rs.getInt("quantity")));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lostBooks;
	}
}