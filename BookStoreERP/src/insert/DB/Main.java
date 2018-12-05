package insert.DB;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			
		InsertDB db = new InsertDB();
		DataDAO data = new DataDAO();
		FileDAO dao = new FileDAO();
//		data.insertStockR();
		data.showStock();
		
//		data.insertSale();
		
//		dao.fileSave("2018-12-03");
//		dao.fileSaveYear();
//		dao.fileLoad("2018-12-03");
		
//		HashMap<String, Integer> total = dao.classificatonSale("2018-12-4");
//		System.out.printf("역사 : %,d원\n", total.get("역사"));
//		System.out.printf("사회정치 : %,d원\n", total.get("사회정치"));
//		System.out.printf("경제경영 : %,d원\n", total.get("경제경영"));
//		System.out.printf("자연과학 : %,d원\n", total.get("자연과학"));
//		System.out.printf("예술 : %,d원\n", total.get("예술"));
//		System.out.printf("수험서 : %,d원\n", total.get("수험서"));
//		System.out.printf("합계 : %,d원", (total.get("역사") + total.get("사회정치") + total.get("경제경영") +
//				total.get("자연과학") + total.get("예술") + total.get("수험서")));
				
	}
}
