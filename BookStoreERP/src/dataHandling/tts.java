package dataHandling;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class tts {

	public static void main(String[] args) {
		StatisticsDAO dao = new StatisticsDAO();
//		ArrayList<FileDTO> dto = new ArrayList<>();
//		HashMap<String, Integer> total = new HashMap<>();

//		total = dao.classificatonSale("test");
//		System.out.println(total.get("역사"));
//		dao.fileLoad("test");
//		dao.fileSave("20181214");
		
//		dao.fileSaveYear();
//		dao.fileLoadTotal("20181117", "20181210");
		
		Calendar cal = Calendar.getInstance();
		
		int count = 2;
		do {
			System.out.println("Hello, Amanda.");
			if(count == 0) {
				count = 1;
			}
		} while (count == 0);
		
	}

}
