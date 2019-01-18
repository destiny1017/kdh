package bean;

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
			dto.setCategory(rs.getString("category"));
		}
		pool.freeConnection(con, ps, rs);
		return dto;

	}
	
	public ArrayList<ProductDTO> getInfoCategory(String Category) throws Exception {
		con = pool.getConnection();
		// 3. SQL문 객체화
		String sql = "select * from product where Category=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Category);
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
	
	public ArrayList<ProductDTO> getInfoName(String search) throws Exception {
		con = pool.getConnection();
		// 3. SQL문 객체화
		String search2 = "%"+search+"%";
		String sql = "select * from product where name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, search2);
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
	
	public void insertHit(ArrayList<String> recommend) throws Exception {
		con = pool.getConnection();
		// 3. SQL문 객체화
		PreparedStatement ps = null;
		for (int i = 0; i < recommend.size(); i++) {
			String sql = "update product set hit = hit+1 where pid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, recommend.get(i));
			ps.executeUpdate();
		}
		
		pool.freeConnection(con, ps);
		

	}
	
	public ArrayList<ProductDTO> getInfoHit() throws Exception {
		con = pool.getConnection();
		// 3. SQL문 객체화
		String sql = "select * from product order by hit desc";
		PreparedStatement ps = con.prepareStatement(sql);
		// 4. SQL문 실행 요청
		ResultSet rs = ps.executeQuery();
		ArrayList<ProductDTO> list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			rs.next();
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
	
	   //======================================내가 만든 메서드=============================================
	   
	   public void addProduct(ProductDTO dto) throws Exception {
		   
		   String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		   
		   con = pool.getConnection();
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   	   
		   pstmt.setString(1, dto.getPId());
		   pstmt.setString(2, dto.getName());
		   pstmt.setString(3, dto.getExplanation());
		   pstmt.setString(4, dto.getPrice());
		   pstmt.setString(5, dto.getSizeS());
		   pstmt.setString(6, dto.getSizeM());
		   pstmt.setString(7, dto.getSizeL());
		   pstmt.setString(8, dto.getSizeXL());
		   pstmt.setString(9, dto.getCategory());
		   pstmt.setString(10, "0");
		   
		   pstmt.executeUpdate();
		   
		   pool.freeConnection(con, pstmt);
	   }
	   
	   public void updateProduct(ProductDTO dto) throws Exception {
		   
		   String sql = "update product set name=?, explanation=?, price=?, "
		   		+ "sizeS=?, sizeM=?, sizeL=?, sizeXL=? where pId=?";
		   
		   con = pool.getConnection();
		   PreparedStatement pstmt = con.prepareStatement(sql);

		   pstmt.setString(1, dto.getName());
		   pstmt.setString(2, dto.getExplanation());
		   pstmt.setString(3, dto.getPrice());
		   pstmt.setString(4, dto.getSizeS());
		   pstmt.setString(5, dto.getSizeM());
		   pstmt.setString(6, dto.getSizeL());
		   pstmt.setString(7, dto.getSizeXL());
		   pstmt.setString(8, dto.getPId());
		   
		   pstmt.executeUpdate();
		   
		   pool.freeConnection(con, pstmt);
	   }
	   
	   public void deleteProduct(String pId) throws Exception {
		   
		   String sql = "delete from product where pId='" + pId + "'";
		   
		   con = pool.getConnection();
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   
		   pstmt.executeUpdate();
		   
		   pool.freeConnection(con, pstmt);
	   }
	   
	   //======================================내가 만든 메서드=============================================
}
