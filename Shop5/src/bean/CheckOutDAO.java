package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CheckOutDAO {
	DBConnectionMgr pool;
	Connection con;

	public CheckOutDAO() {

		pool = DBConnectionMgr.getInstance();
	}

	public void checkout(String uId) throws Exception {
		con = pool.getConnection();

		// 로그인한 유저의 장바구니를 다 가져온다.
		String sql = "select * from addcart where uid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sql = "insert into checkout value(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, rs.getString("uid"));
			ps.setString(2, rs.getString("pid"));
			ps.setString(3, rs.getString("size"));
			ps.setString(4, rs.getString("count"));
			ps.executeUpdate();
		}
		sql = "delete from addcart where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, uId);
		ps.executeUpdate();

		pool.freeConnection(con, ps, rs);

	}
	
	public ArrayList<CheckOutDTO> getCheckOutInfo(String uId) throws Exception {
		con = pool.getConnection();
		
		String sql = "select * from checkout where uid = '" + uId + "'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<CheckOutDTO> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new CheckOutDTO(
				rs.getString("uid"),
				rs.getString("pid"),
				rs.getString("size"),
				rs.getString("count")					
			));		
		}
		return list;
	}
}