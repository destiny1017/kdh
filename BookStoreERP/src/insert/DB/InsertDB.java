package insert.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InsertDB {
	
	public void insert(String classification, String[][] data) {
		
		DataDTO[] dto = new DataDTO[data.length];
		
		for (int i = 0; i < data.length; i++) {
			String price = data[i][4];
			price = price.substring(0,price.indexOf("원"));
			StringBuilder s = new StringBuilder(price);
			price = s.delete(s.indexOf(","), s.indexOf(",")+1).toString();
			int intPrice = Integer.parseInt(price);
			
			dto[i] = new DataDTO(data[i][1], data[i][3], intPrice, data[i][6], data[i][7]);
			System.out.println(i + "번째 dto의 isbn : " + dto[i].getIsbn() + ", title : " + dto[i].getTitle()
								+ ", writer : " + dto[i].getWriter() + ", publisher : " + dto[i].getPublisher()
								+ ", price : " + dto[i].getPrice()); 
		}

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "insert into books values(?,?,?,?,?,?)";
		String sql2 = "select * from books";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
			ArrayList<String> isbn = new ArrayList<>();
			int overlap = 0;
			
			while(rs.next()) {
				isbn.add(rs.getString("isbn"));
			}
			
			for (int i = 0; i < dto.length; i++) {			
				overlap = 0;
				for (int j = 0; j < isbn.size(); j++) {
					if(dto[i].getIsbn().equals(isbn.get(j))) {
						overlap = 1;
						break;
					}
				}
				
				if(overlap != 1) {					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, dto[i].getIsbn());
					pstmt.setString(2, classification);
					pstmt.setString(3, dto[i].getTitle());
					pstmt.setString(4, dto[i].getPublisher());
					pstmt.setString(5, dto[i].getWriter());
					pstmt.setInt(6, dto[i].getPrice());
					
					pstmt.executeUpdate();
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
