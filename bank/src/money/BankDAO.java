package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BankDAO {
	
	public void insert(BankDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String uid = "root";
		String upw = "1234";
		String sql = "insert into member values(?,?,?,?)";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getTel());
			
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "고객정보가 정상적으로 등록되었습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modify(BankDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String uid = "root";
		String upw = "1234";
		String sql = "update member set tel = ? where id = ?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getTel());
			pstmt.setString(2, member.getId());

			
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "고객정보가 정상적으로 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "해당 고객이 존재하지 않습니다");
		}
	}
	
	public void delete(String id) {
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String uid = "root";
		String upw = "1234";
		String sql = "delete from member where id = '" + id + "'";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "고객정보가 정상적으로 삭제되었습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BankDTO> search(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from member where id = '" + id +"'";
		
		ArrayList<BankDTO> member = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.add(new BankDTO(rs.getString("id"), rs.getString("name"),
						rs.getShort("age"), rs.getString("tel")));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	public ArrayList<BankDTO> list() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from member";
		
		ArrayList<BankDTO> member = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.add(new BankDTO(rs.getString("id"), rs.getString("name"),
						rs.getShort("age"), rs.getString("tel")));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}
