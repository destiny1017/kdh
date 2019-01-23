package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product.DBConnectionMgr;

public class ProductDAO {
	
	//커넥션 관련 변수 선언
	DBConnectionMgr pool;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	//커넥션 객체 생성자
	public ProductDAO() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//등록
	public int insert(ProductDTO dto) {
		
		String sql = "insert into product values(?,?,?,?)";
		int result = 0; //쿼리 실행결과 반환 값
		
		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDetail());
			pstmt.setInt(4, dto.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
		return result;
	}
	
	//수정
	public int update(ProductDTO dto){
		
		String sql = "update product set detail=?, price=? where id=?";
		int result = 0;
		
		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getDetail());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}		
		return result;
	}
	
	//삭제
	public int delete(String id) {
		
		String sql = "delete from product where id='" + id + "'";
		int result = 0;
		
		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}		
		return result;
	}
	
	//검색
	public ProductDTO select(String id) {
		
		String sql = "select * from product where id='" + id + "'";
		ProductDTO info = null;
		
		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				info = new ProductDTO(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("detail"),
						rs.getInt("price")
					);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}	
		return info;
	}
	
	//전체검색
	public ArrayList<ProductDTO> selectAll() {
		
		String sql = "select * from product";
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductDTO(
							rs.getString("id"),
							rs.getString("name"),
							rs.getString("detail"),
							rs.getInt("price")
						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return list;
	}

}
