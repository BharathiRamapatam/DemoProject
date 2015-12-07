package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.datatable.Xls_Reader;

public class TestBase {
	public static Properties prop ;
	public static WebDriver driver ;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet Sheet1;
	public static FileOutputStream out;
	public static Xls_Reader xls ;
	public static JavascriptExecutor jse;
	public static WebDriverWait wait;
	public static XSSFCell cell;
	
	
	public static void initiliase() throws IOException{
		try {
			FileInputStream fis = new FileInputStream ("C:\\Users\\bharathi.ramapatnam\\Documents\\MavenProjects\\DemoProject\\src\\com\\demo\\config\\config.properties");
			prop.load(fis);
			System.out.println(prop.getProperty("browser"));
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(prop.getProperty("browser").equals("Firefox")){
			 driver = new FirefoxDriver ();
		}else if(prop.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\bharathi.ramapatnam\\Downloads\\chromedriver_win32\\chromedriver.exe");
		     driver= new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("IE")){
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();					
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);					
			System.setProperty("webdriver.ie.driver", "C:\\Users\\bharathi.ramapatnam\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");	
		//"C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Jars\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		
		
	}
	public static void write(int rowNum, int cellNum,String data) throws IOException{
	
	File src = new File("C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Excels\\DemoProjectOrignalcopy.xlsx");
	//C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Excels\\DemoProjectOrignal2.xlsx
	FileInputStream fis = new FileInputStream(src);
	 wb = new XSSFWorkbook(fis);
	 Sheet1 = wb.getSheetAt(0);
	Sheet1.getRow(rowNum).createCell(cellNum).setCellValue(data);
	
	FileOutputStream out = new FileOutputStream(src);
	wb.write(out);
	wb.close();
	}
	
	public static void scrollToElement(WebElement element, WebDriver driver) {
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void waitUntilElementByxpath(String ele_xpath) {
		 wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele_xpath)));
	    
	}
	/*
	public static void setCellColourGreen(String sheet, String colName,int rowNum){
		CellStyle style = Xls_Reader.workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
	}*/
	
	

}
