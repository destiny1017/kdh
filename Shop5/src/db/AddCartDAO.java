package db;

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