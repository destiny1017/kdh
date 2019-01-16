package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

public class BbsDAO {

	private Connection con;
	private ResultSet rs;

	public BbsDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "1234");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public String getDate() {
		String sql = "select now()";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public int getNext(String bbsCategories) {
		String sql = "select bbsId from bbs_" + bbsCategories +  " order by bbsId desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int write(String bbsTitle, String bbsContent, String bbsCategories) {
		String sql = "insert into bbs_" + bbsCategories +  " values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext(bbsCategories));
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, "admin");	// �� ���̵�
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setString(6, bbsCategories);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, getNext(bbsCategories));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return -1; // ����
	}
	
	public int reviewWrite(String bbsTitle, String bbsContent, String bbsCategories, String fileName1, String star) {
		String sql = "insert into bbs_" + bbsCategories +  " values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext(bbsCategories));
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, "admin");	// �� ���̵�
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setString(6, bbsCategories);
			pstmt.setString(7, fileName1);
			pstmt.setString(8, star);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return -1; // ����
	}

	public ArrayList<BbsDTO> newsList(int pageNumber) {
		String sql = "select * from bbs_news where bbsId<? order by bbsId desc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext("news") - ((pageNumber - 1) * 10));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBbsId(rs.getInt(1));
				dto.setBbsTitle(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setBbsDate(rs.getString(4));
				dto.setBbsContent(rs.getString(5));
				dto.setBbsCategories(rs.getString(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BbsDTO> qaList(int pageNumber) {
		String sql = "select * from bbs_qa where bbsId<? order by renum desc, reply asc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext("qa") - ((pageNumber - 1) * 10));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBbsId(rs.getInt(1));
				dto.setBbsTitle(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setBbsDate(rs.getString(4));
				dto.setBbsContent(rs.getString(5));
				dto.setBbsCategories(rs.getString(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BbsDTO> reivewList(int pageNumber) {
		String sql = "select * from bbs_review where bbsId<? order by bbsId desc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext("review") - ((pageNumber - 1) * 10));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBbsId(rs.getInt(1));
				dto.setBbsTitle(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setBbsDate(rs.getString(4));
				dto.setBbsContent(rs.getString(5));
				dto.setBbsCategories(rs.getString(6));
				dto.setImg(rs.getString(7));
				dto.setStar(rs.getString(8));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BbsDTO> noticeList(int pageNumber) {
		String sql = "select * from bbs_notice where bbsId<? order by bbsId desc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext("notice") - ((pageNumber - 1) * 10));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBbsId(rs.getInt(1));
				dto.setBbsTitle(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setBbsDate(rs.getString(4));
				dto.setBbsContent(rs.getString(5));
				dto.setBbsCategories(rs.getString(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BbsDTO getBbs(String bbsCategories, int bbsId) {
		String sql = "select * from bbs_" + bbsCategories +  " where bbsId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbsId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBbsId(rs.getInt(1));
				dto.setBbsTitle(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setBbsDate(rs.getString(4));
				dto.setBbsContent(rs.getString(5));
				dto.setBbsCategories(rs.getString(6));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public int update(int bbsId, String bbsTitle, String bbsContent, String bbsCategories) {
		System.out.println(bbsContent);
		String sql = "update bbs_" + bbsCategories + " set bbsTitle=?, bbsContent=? where bbsId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(int bbsId, String bbsCategories) {
		String sql = "delete from bbs_" + bbsCategories + " where bbsId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbsId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deleteNum(int bbsId, String bbsCategories) {
		String sql2 = "update bbs_" + bbsCategories + " set bbsId=bbsId-1 where bbsId>?";
		try {
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, bbsId);
			return pstmt2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<BbsDTO> searchList(String bbsCategories, String col, String word) {
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			if(col.equals("none")) {
				String sql = "select * from bbs_" + bbsCategories + " where userId LIKE ? or bbsContent LIKE ? or bbsTitle LIKE ? order by bbsId desc";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BbsDTO dto = new BbsDTO();
					dto.setBbsId(rs.getInt(1));
					dto.setBbsTitle(rs.getString(2));
					dto.setUserId(rs.getString(3));
					dto.setBbsDate(rs.getString(4));
					dto.setBbsContent(rs.getString(5));
					dto.setBbsCategories(rs.getString(6));
					list.add(dto);
				}
			}
			else if(col.equals("rname")) {
				String sql = "select * from bbs_" + bbsCategories + " where userId LIKE ? order by bbsId desc";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BbsDTO dto = new BbsDTO();
					dto.setBbsId(rs.getInt(1));
					dto.setBbsTitle(rs.getString(2));
					dto.setUserId(rs.getString(3));
					dto.setBbsDate(rs.getString(4));
					dto.setBbsContent(rs.getString(5));
					dto.setBbsCategories(rs.getString(6));
					list.add(dto);
				}
			}
			else if(col.equals("title")) {
				String sql = "select * from bbs_" + bbsCategories + " where bbsTitle LIKE ? order by bbsId desc";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BbsDTO dto = new BbsDTO();
					dto.setBbsId(rs.getInt(1));
					dto.setBbsTitle(rs.getString(2));
					dto.setUserId(rs.getString(3));
					dto.setBbsDate(rs.getString(4));
					dto.setBbsContent(rs.getString(5));
					dto.setBbsCategories(rs.getString(6));
					list.add(dto);
				}

			}
			else if(col.equals("content")) {
				String sql = "select * from bbs_" + bbsCategories + " where bbsContent LIKE ? order by bbsId desc";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BbsDTO dto = new BbsDTO();
					dto.setBbsId(rs.getInt(1));
					dto.setBbsTitle(rs.getString(2));
					dto.setUserId(rs.getString(3));
					dto.setBbsDate(rs.getString(4));
					dto.setBbsContent(rs.getString(5));
					dto.setBbsCategories(rs.getString(6));
					list.add(dto);
				}

			}
			else if(col.equals("title_content")) {
				String sql = "select * from bbs_" + bbsCategories + " where bbsTitle LIKE ? or bbsContent LIKE ? order by bbsId desc";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BbsDTO dto = new BbsDTO();
					dto.setBbsId(rs.getInt(1));
					dto.setBbsTitle(rs.getString(2));
					dto.setUserId(rs.getString(3));
					dto.setBbsDate(rs.getString(4));
					dto.setBbsContent(rs.getString(5));
					dto.setBbsCategories(rs.getString(6));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int qaReply(String bbsTitle, String bbsContent, String bbsCategories, String bbsId) {
		String sql = "insert into bbs_qa values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getNext(bbsCategories));
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, "admin");	// �� ���̵�
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setString(6, bbsCategories);
			pstmt.setInt(7, 1);
			pstmt.setInt(8, Integer.parseInt(bbsId));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return -1; // ����
	}
}
