package dataHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDAO {
	ArrayList<BookTotalDTO> books = new ArrayList<>();

	// 도서등록
	public void insert(OrderDTO dto) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/erp";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "insert into books_order values(null,?,?,null)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dto.getIsbn());
			ps.setInt(2, dto.getQuantity());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String sql = "select books.* ,books_order.no,books_order. quantity,books_order. TS from books_order,books where books_order. isbn=books.isbn";
		books = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				books.add(new BookTotalDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("no"),
						rs.getInt("quantity"), rs.getString("TS")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
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
		
		books = new ArrayList<>();

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