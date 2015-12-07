package tests;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

public class SetCellColour {

	public static void main(String[] args) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Eggs");
		Cell cell = sheet.createRow(0).createCell(0);
		
		FileOutputStream fis = new FileOutputStream("C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Excels\\writeToExcel2.xlsx");
		workbook.write(fis);
		workbook.close();
		fis.close();
		
		
		

	}

}
