package insert.DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelData2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		String[] files = new File("bookDB").list();
		try {		  
			String clsf = "자연과학";
			FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\엑셀db\\자연과학3.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0); // 해당 엑셀파일의 시트(Sheet) 수
			int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
			
			String[][] contents = new String[rows-1][8];
	
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
				
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells(); //현재 행의 셀의 개수를 카운트
					for (int columnIndex = 0; columnIndex < cells-1; columnIndex++) { // "설명"항목은 제외
						HSSFCell cell = row.getCell(columnIndex); // 셀에 담겨있는 값을 읽는다.
						String value = "";
						switch (cell.getCellType()) { // 각 셀에 담겨있는 데이터의 타입을 체크하고 해당 타입에 맞게 가져온다.
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
						contents[rowIndex-1][columnIndex] = value;
					}
//	                    System.out.println(Arrays.toString(contents[rowIndex-1]));
//	                    System.out.println("==================================");
				}
			}
			new InsertDB().insert(clsf, contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  

	}

}
