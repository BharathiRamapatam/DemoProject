package tests;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.datatable.Xls_Reader;

public class Rough {
	
	

	public static void main(String[] args) {
		
		Xls_Reader xls = new Xls_Reader("C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Excels\\writeToExcel2.xlsx");
		//xls.setCellData("Sheet1", "Pass", 1, "Fail");
		//xls.setCellData("Sheet1", "Pass", 1, "Fail");
		//xls.setCellData("Sheet1", "Fail", 2, "Pass");
		//xls.setCellData("Sheet1", "password", 2, "1234");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Eggs");
		/*
		Cell cell = sheet.
		
		
		
	
	
	
		
		CellStyle style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		*/
		
		
		
	

	}

}
