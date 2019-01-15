package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddCartDAO {
	DBConnectionMgr pool;
	Connection con;

	public AddCartDAO() {

		pool = DBConnectionMgr.getInstance();
	}

	public void insertInfo(String uId, String pId, String size, String count) throws Exception {
		con = pool.getConnection();

		// 로그인한 유저의 장바구니를 다 가져온다.
		String sql = "select * from addcart where uid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uId);
		ResultSet rs = ps.executeQuery();
		int check = 0;
		while (rs.next()) {
			if (pId.equals(rs.getString("pid")) && size.equals(rs.getString("size"))) {
				check++;
			}
		}

		// 장바구니에 넣을려는 제품과 사이즈가 동일한 내용이 있다면 추가말고 업데이트를 한다.
		if (check != 0) {
			sql = "update addcart set count=? where uid=? and pid=? and size=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, count);
			ps.setString(2, uId);
			ps.setString(3, pId);
			ps.setString(4, size);
			ps.executeUpdate();
			
			// 장바구니에 넣을려는 제품과 사이즈가 동일한 내용이 없다면 추가한다.
		} else {
			
			sql = "insert into addcart value(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, uId);
			ps.setString(2, pId);
			ps.setString(3, size);
			ps.setString(4, count);
			ps.executeUpdate();

		}
		pool.freeConnection(con, ps, rs);

	}

	public void insertInfo2(String uId, String pId, String size, String count) throws Exception {
		con = pool.getConnection();

		// 3. SQL문 객체화
		String sql = "insert into addcart value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uId);
		ps.setString(2, pId);
		ps.setString(3, size);
		ps.setString(4, count);

		// 4. SQL문 실행 요청
		ps.executeUpdate();
		pool.freeConnection(con, ps);

	}

	public void deleteInfo(String uId, String pId, String size) throws Exception {
		con = pool.getConnection();
		// 3. SQL문 객체화
		String sql = "delete from addcart where uid=? and pid=? and size=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uId);
		ps.setString(2, pId);
		ps.setString(3, size);

		// 4. SQL문 실행 요청
		ps.executeUpdate();
		pool.freeConnection(con, ps);

	}

	public ArrayList<AddCartDTO> getInfo(String uId) throws Exception {
		con = pool.getConnection();

		// 3. SQL문 객체화
		String sql = "select * from addcart where uid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uId);

		// 4. SQL문 실행 요청
		ResultSet rs = ps.executeQuery();

		ArrayList<AddCartDTO> list = new ArrayList<>();
		while (rs.next()) {
			AddCartDTO dto = new AddCartDTO();
			dto.setuId(rs.getString("uId"));
			dto.setpId(rs.getString("pId"));
			dto.setSize(rs.getString("size"));
			dto.setCount(rs.getString("count"));
			list.add(dto);
		}
		pool.freeConnection(con, ps, rs);
		return list;

	}
}
