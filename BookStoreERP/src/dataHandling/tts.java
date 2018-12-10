package dataHandling;

import java.util.ArrayList;
import java.util.HashMap;

public class tts {

	public static void main(String[] args) {
		FileDAO dao = new FileDAO();
//		ArrayList<FileDTO> dto = new ArrayList<>();
		HashMap<String, Integer> total = new HashMap<>();

//		total = dao.classificatonSale("test");
//		System.out.println(total.get("역사"));
//		dao.fileLoad("test");
		dao.fileSave("20181210");
		
//		dao.fileSaveYear();
	}

}
