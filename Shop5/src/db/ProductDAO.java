package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {

   DBConnectionMgr pool;
   Connection con;

   public ProductDAO() {
      // TODO Auto-generated constructor stub
      pool = DBConnectionMgr.getInstance();
   }

   public ProductDTO getInfo(String pId) throws Exception {
      con = pool.getConnection();

      // 3. SQL문 객체화
      String sql = "select * from product where pId = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, pId);

      // 4. SQL문 실행 요청
      ResultSet rs = ps.executeQuery();
      ProductDTO dto = new ProductDTO();
      while (rs.next()) {
         dto.setPId(rs.getString("pId"));
         dto.setName(rs.getString("name"));
         dto.setExplanation(rs.getString("explanation"));
         dto.setPrice(rs.getString("price"));
         dto.setSizeS(rs.getString("sizeS"));
         dto.setSizeM(rs.getString("sizeM"));
         dto.setSizeL(rs.getString("sizeL"));
         dto.setSizeXL(rs.getString("sizeXL"));
      }
      pool.freeConnection(con, ps, rs);
      return dto;

   }

   public ArrayList<ProductDTO> getInfoALL() throws Exception {
      con = pool.getConnection();
      // 3. SQL문 객체화
      String sql = "select * from product";
      PreparedStatement ps = con.prepareStatement(sql);

      // 4. SQL문 실행 요청
      ResultSet rs = ps.executeQuery();
      ArrayList<ProductDTO> list = new ArrayList<>();
      while (rs.next()) {
         ProductDTO dto = new ProductDTO();
         dto.setPId(rs.getString("pId"));
         dto.setName(rs.getString("name"));
         dto.setExplanation(rs.getString("explanation"));
         dto.setPrice(rs.getString("price"));
         dto.setSizeS(rs.getString("sizeS"));
         dto.setSizeM(rs.getString("sizeM"));
         dto.setSizeL(rs.getString("sizeL"));
         dto.setSizeXL(rs.getString("sizeXL"));
         dto.setCategory(rs.getString("category"));
         list.add(dto);
      }
      pool.freeConnection(con, ps, rs);
      return list;
   }
}