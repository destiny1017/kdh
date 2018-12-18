package dataHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class StatisticsDAO {
	
	ArrayList<StatisticsDTO> file = new ArrayList<>();
	HashMap<String, Integer> total = new HashMap<>();	
	
	//매출 파일을 저장하는 메서드
	public void fileSave(String date) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		ArrayList<StatisticsDTO> fileSave = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select books.isbn, books.classification, books.title, books.price, total_sale.salesVolume, "
				+ "books.publisher from books, total_sale where books.isbn = total_sale.isbn";
			
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			FileOutputStream fos = new FileOutputStream(new File("SaleData/" + date + ".list"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			while(rs.next()) {
				if(rs.getInt("salesVolume") > 0) {					
					String isbn = rs.getString("isbn");
					String classification = rs.getString("classification");
					String title = rs.getString("title");
					int price = rs.getInt("price");
					int salesVolume = rs.getInt("salesVolume");
					String publisher = rs.getString("publisher");
					fileSave.add(new StatisticsDTO(isbn, classification, title, price, salesVolume, publisher));
				}				
			}
			
			oos.writeObject(fileSave);
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//매출 파일 저장 반복 메서드(테스트용)
	public void fileSaveYear() {
			
		int year = 2018;
		int month = 10;
		int day = 20;
		
		int[] dayOfMomth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		DecimalFormat df = new DecimalFormat("00");
		StockDAO dao = new StockDAO();
		
		for (int i = 1; i <= 30; i++) {
			
			String date = "" + year + df.format(month+1) + df.format(day);
			
			dao.insertSale();
			fileSave(date);
			
			if(day == dayOfMomth[month]) {
				day = 0;
				month++;
			}		
			if(month == 12) {
				month = 0;
				year++;
			}
			day++;
		}
	}
	
	//매출파일을 불러오는 메서드
	public ArrayList<StatisticsDTO> fileLoad(String date) {
			
		try {
			
			FileInputStream fis = new FileInputStream(new File("SaleData/" + date + ".list"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			file = (ArrayList<StatisticsDTO>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	public ArrayList<StatisticsDTO> fileLoadTotal(String date) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		HashMap<String, Integer> total = new HashMap<>();
		ArrayList<StatisticsDTO> result = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books";
		
		try {
			
			ArrayList<ArrayList<StatisticsDTO>> saleList = new ArrayList<>();
			String[] fList = new File("SaleData").list();
			for (int i = 0; i < fList.length; i++) {
				if(fList[i].substring(0, 6).equals(date)) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SaleData/" + fList[i])));
					saleList.add((ArrayList<StatisticsDTO>) ois.readObject());
				}
			}
						
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				total.put(rs.getString("isbn"), 0);
			}
					
			for (int i = 0; i < saleList.size(); i++) {
				for (int j = 0; j < saleList.get(i).size() ; j++) {
					String isbn = saleList.get(i).get(j).getIsbn();
					int salesVolume = saleList.get(i).get(j).getSalesVolume();
					total.put(isbn, total.get(isbn) + salesVolume);
				}
			}
			
			rs.beforeFirst();
			while(rs.next()) {
				result.add(new StatisticsDTO(rs.getString("isbn"), rs.getString("classification"), 
						rs.getString("title"), rs.getInt("price"), total.get(rs.getString("isbn")), 
						rs.getString("publisher")));
			}
									
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public ArrayList<StatisticsDTO> fileLoadTotal(String date1, String date2) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		int year = Integer.parseInt(date1.substring(0, 4));
		int month = Integer.parseInt(date1.substring(4, 6))-1;
		int day = Integer.parseInt(date1.substring(6));
		
		int[] dayOfMomth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		DecimalFormat df = new DecimalFormat("00");
		
			
		HashMap<String, Integer> total = new HashMap<>();
		ArrayList<StatisticsDTO> result = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books";
		
		try {
			
			ArrayList<ArrayList<StatisticsDTO>> saleList = new ArrayList<>();
			String[] fList = new File("SaleData").list();
			
			while(!date1.equals(date2)) {
				try {			
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SaleData/" + date1 + ".list")));
					saleList.add((ArrayList<StatisticsDTO>) ois.readObject());
				} catch (Exception e) {
				}
				
				if(day == dayOfMomth[month]) {
					day = 0;
					month++;
				}
				if(month == 12) {
					month = 0;
					year++;
				}
				day++;
				date1 = "" + year + df.format(month+1) + df.format(day);
				
				if(year>2020) {
					JOptionPane.showMessageDialog(null, "날짜범위가 잘못되었습니다.");
					return file;
				}
			}
			
			try {			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SaleData/" + date1 + ".list")));
				saleList.add((ArrayList<StatisticsDTO>) ois.readObject());
			} catch (Exception e) {
			}
						
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				total.put(rs.getString("isbn"), 0);
			}
					
			for (int i = 0; i < saleList.size(); i++) {
				for (int j = 0; j < saleList.get(i).size() ; j++) {
					String isbn = saleList.get(i).get(j).getIsbn();
					int salesVolume = saleList.get(i).get(j).getSalesVolume();
					total.put(isbn, total.get(isbn) + salesVolume);
				}
			}
			
			rs.beforeFirst();
			while(rs.next()) {
				result.add(new StatisticsDTO(rs.getString("isbn"), rs.getString("classification"), 
						rs.getString("title"), rs.getInt("price"), total.get(rs.getString("isbn")), 
						rs.getString("publisher")));
			}
									
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	//서가별 매출을 반환하는 메서드
	public HashMap<String, Integer> classificatonSale(ArrayList<StatisticsDTO> sale) {
		
		ArrayList<StatisticsDTO> society = new ArrayList<>();				
		ArrayList<StatisticsDTO> economy = new ArrayList<>();				
		ArrayList<StatisticsDTO> history = new ArrayList<>();				
		ArrayList<StatisticsDTO> science = new ArrayList<>();				
		ArrayList<StatisticsDTO> art = new ArrayList<>();				
		ArrayList<StatisticsDTO> examination = new ArrayList<>();
		
		total.put("사회정치", 0);
		total.put("경제경영", 0);
		total.put("역사", 0);
		total.put("자연과학", 0);
		total.put("예술", 0);
		total.put("수험서", 0);
		
		for (int i = 0; i < sale.size(); i++) {
			switch (sale.get(i).getClassification()) {
			case "사회정치":
				society.add(sale.get(i));
				total.put("사회정치", total.get("사회정치") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "경제경영":
				economy.add(sale.get(i));
				total.put("경제경영", total.get("경제경영") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "역사":
				history.add(sale.get(i));
				total.put("역사", total.get("역사") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "자연과학":
				science.add(sale.get(i));
				total.put("자연과학", total.get("자연과학") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "예술":
				art.add(sale.get(i));
				total.put("예술", total.get("예술") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "수험서":
				examination.add(sale.get(i));
				total.put("수험서", total.get("수험서") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			}
		}		
		return total;
	}
	
	public HashMap<String, Integer> classificatonSaleP(ArrayList<StatisticsDTO> sale) {
		
		HashMap<String, Integer> total = new HashMap<>();
		ArrayList<StatisticsDTO> society = new ArrayList<>();				
		ArrayList<StatisticsDTO> economy = new ArrayList<>();				
		ArrayList<StatisticsDTO> history = new ArrayList<>();				
		ArrayList<StatisticsDTO> science = new ArrayList<>();				
		ArrayList<StatisticsDTO> art = new ArrayList<>();				
		ArrayList<StatisticsDTO> examination = new ArrayList<>();
		
		total.put("사회정치", 0);
		total.put("경제경영", 0);
		total.put("역사", 0);
		total.put("자연과학", 0);
		total.put("예술", 0);
		total.put("수험서", 0);
		
		for (int i = 0; i < sale.size(); i++) {
			switch (sale.get(i).getClassification()) {
			case "사회정치":
				society.add(sale.get(i));
				total.put("사회정치", total.get("사회정치") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "경제경영":
				economy.add(sale.get(i));
				total.put("경제경영", total.get("경제경영") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "역사":
				history.add(sale.get(i));
				total.put("역사", total.get("역사") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "자연과학":
				science.add(sale.get(i));
				total.put("자연과학", total.get("자연과학") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "예술":
				art.add(sale.get(i));
				total.put("예술", total.get("예술") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			case "수험서":
				examination.add(sale.get(i));
				total.put("수험서", total.get("수험서") + (sale.get(i).getPrice() * sale.get(i).getSalesVolume()));
				break;
			}
		}		
		return total;
	}

}
