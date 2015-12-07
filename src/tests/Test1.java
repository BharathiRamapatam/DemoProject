package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.datatable.Xls_Reader;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class Test1 extends TestBase {
	public static CellStyle style;
	public static Logger APP_LOGS;
	@BeforeClass
	public static void initilise(){
		APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Hello");
		
		xls = new Xls_Reader("C:\\Users\\bharathi.ramapatnam\\Documents\\MavenProjects\\DemoProject\\src\\com\\demo\\datatable\\DemoProjectOrignalCopy.xlsx");
		//C:\\Users\\bharathi.ramapatnam\\Documents\\MavenProjects\\DemoProject\\src\\com\\demo\\datatable\\DemoProjectOrignalCopy.xlsx
		
		
	}
	@AfterClass
	public static void afterClass(){
		APP_LOGS.debug("executing after class");
		System.out.println("After class ends");
		
	}
	
	
	@BeforeMethod
	public static void launch(){
		APP_LOGS.debug("Launching browser");
		System.out.println("launching browser");
		String browser = "Firefox";
		if(browser.equals("Firefox")){
			 driver = new FirefoxDriver ();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\bharathi.ramapatnam\\Downloads\\chromedriver_win32\\chromedriver.exe");
		     driver= new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("IE")){
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();					
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);					
			System.setProperty("webdriver.ie.driver", "C:\\Users\\bharathi.ramapatnam\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");	
		//"C:\\Users\\bharathi.ramapatnam\\Documents\\Selenium Jars\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterMethod
	public static void afterMethod() throws InterruptedException{
		APP_LOGS.debug("Closing browser");
		System.out.println("closing browser");
		driver.close();
		
		
	}
	
	@Test
	public static void amazon_co_uk() throws IOException{
		APP_LOGS.debug("executing search on amazon.co.uk");
		System.out.println("");
		
		driver.get("http://www.amazon.co.uk/Selenium-Testing-Cookbook-Unmesh-Gundecha/dp/1849515743/ref=sr_1_2?ie=UTF8&qid=1449074807&sr=8-2&keywords=Selenium+tools+cookbook");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium tools cookbook");
		//driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		//driver.findElement(By.xpath("//img[@src = 'http://ecx.images-amazon.com/images/I/51e3HeXU0qL._AA160_.jpg']")).click();
		String price = driver.findElement(By.xpath("//*[@id='a-autoid-3-announce']/span[2]/span")).getText();
	
		System.out.println(price);
		//Sheet1.getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		xls.setCellData("Sheet1", "ActualPrice", 2,price );
		
		//System.out.println(xls.getCellData("Sheet1", 3, 2));
		//Compare actual and expected result and set the results
		
		String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 2);
		String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 2);
		System.out.println(Actual_Price);
		System.out.println(Expected_Price);
		
		
		if(Actual_Price.equals(Expected_Price)){
			xls.setCellDataGreen("Sheet1", "Result", 2, "Pass");
			
		}else if(!Actual_Price.equals(Expected_Price)){
			xls.setCellDataRed("Sheet1", "Result", 2, "Fail");
			
			}else 
				System.out.println("Error");
				xls.setCellDataRed("Sheet1", "Result", 2, "Error");
			
		

		
		
		
	}
	@Test(priority = 0)
	public static void ebay(){
		APP_LOGS.debug("executing search on ebay");
		driver.get("http://www.ebay.com/");
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Selenium tools cook book");
		driver.findElement(By.id("gh-btn")).click();
		driver.findElement(By.xpath("//*[@id='item27fb23577a']/div/div/a/img")).click();
		String price_ebay = driver.findElement(By.xpath("//*[@id='prcIsum']")).getText();
	
		System.out.println(price_ebay);
		//Sheet1.getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		xls.setCellData("Sheet1", "ActualPrice", 3,price_ebay );
		
		String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 3);
		String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 3);
		System.out.println(Actual_Price);
		System.out.println(Expected_Price);
		
		
		if(Actual_Price.equals(Expected_Price)){
			xls.setCellDataGreen("Sheet1", "Result", 3, "Pass");
			
		}else if(!Actual_Price.equals(Expected_Price)){
			xls.setCellDataRed("Sheet1", "Result", 3, "Fail");
			
			}
			
		
		
		
		
		
	}
	@Test(priority = 1)
	public static void packtPub() throws InterruptedException{
		APP_LOGS.debug("executing search on packtPub");
		driver.get("https://www.packtpub.com");
		driver.findElement(By.cssSelector("#menu-search")).click();
		driver.findElement(By.cssSelector("#main-search-keys")).sendKeys("Selenium tools cook book");
		driver.findElement(By.xpath("//*[@id='edit-submit-5']")).click();
		driver.findElement(By.xpath("//img[@src='//d1ldz4te4covpm.cloudfront.net/sites/default/files/imagecache/featured_book_block/5740OS_Selenium Testing Tools Cookbook.jpg']")).click();
		//driver.switchTo().frame(0);
	    String price_packtPub =  driver.findElement(By.xpath("//*[@id='mobile-book-container']/div[2]/div[5]/div[1]/div[1]/div[1]")).getText();
	    System.out.println(price_packtPub);
	    xls.setCellData("Sheet1", "ActualPrice", 4,price_packtPub );
	    
		String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 4);
		String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 4);
		System.out.println(Actual_Price);
		System.out.println(Expected_Price);
		
		
		if(Actual_Price.equals(Expected_Price)){
			xls.setCellDataGreen("Sheet1", "Result", 4, "Pass");
			
		}else if(!Actual_Price.equals(Expected_Price)){
			xls.setCellDataRed("Sheet1", "Result", 4, "Fail");
			
			}
			
	    	
	}
	@Test
	public static void amazon_com() throws InterruptedException{
		APP_LOGS.debug("executing search on amazon.com");
		
	/*
		driver.get("http://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium tools cook book");
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
	
		List<WebElement> results = driver.findElements(By.xpath("//*[@id='result_0']/div/div/div/div/div/div/a"));
		System.out.println(results.size());
		for (int i = 0; i < results.size();i++){
			results.get(0).click();
			
		
			
			*/
			driver.get("http://www.amazon.com/Selenium-Testing-Cookbook-Gundecha-Unmesh/dp/1849515743/ref=sr_1_1?ie=UTF8&qid=1448998061&sr=8-1&keywords=Selenium+tools+cook+book");
			//span[@class='a-color-price']
			String ele = driver.findElement(By.xpath("//span[@class='a-color-price']")).getText();
			System.out.println(ele);
			xls.setCellData("Sheet1", "ActualPrice", 5,ele );
			
			String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 5);
			String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 5);
			System.out.println(Actual_Price);
			System.out.println(Expected_Price);
			
			
			if(Actual_Price.equals(Expected_Price)){
				xls.setCellDataGreen("Sheet1", "Result", 5, "Pass");
				
			}else if(!Actual_Price.equals(Expected_Price)){
				xls.setCellDataRed("Sheet1", "Result", 5, "Fail");
				
				}
				
		}
		
		
		
		
			
		
		
		
		
		
		


	    //xls.setCellData("Sheet1", "ExpectedPrice", 4,price_amazon_com );
	    	
	
	

	@Test
	public static void amazon_comSecondEdition() throws InterruptedException{
		APP_LOGS.debug("executing search on amazon secon edition");
	/*
		driver.get("http://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium tools cook book");
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
	
		List<WebElement> results = driver.findElements(By.xpath("//*[@id='result_0']/div/div/div/div/div/div/a"));
		System.out.println(results.size());
		for (int i = 0; i < results.size();i++){
			results.get(0).click();
			driver.close();
			//Thread.sleep(8000);
			WebDriver driver = new FirefoxDriver();
			*/
			driver.get("http://www.amazon.com/Selenium-Testing-Tools-Cookbook-Second/dp/1784392510/ref=sr_1_fkmr1_1?ie=UTF8&qid=1449073882&sr=8-1-fkmr1&keywords=Selenium+tools+cook+book");
			//span[@class='a-color-price']
			String ele = driver.findElement(By.xpath("//*[@id='buyNewSection']/h5/div/div[2]/div/span[2]")).getText();
			System.out.println(ele);
			xls.setCellData("Sheet1", "ActualPrice", 6,ele );
			
			String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 6);
			String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 6);
			System.out.println(Actual_Price);
			System.out.println(Expected_Price);
			
			
			if(Actual_Price.equals(Expected_Price)){
				xls.setCellDataGreen("Sheet1", "Result", 6, "Pass");
				
			}else if(!Actual_Price.equals(Expected_Price)){
				xls.setCellDataRed("Sheet1", "Result", 6, "Fail");
				
				}
				
		}
	@Test(priority = 3)
	public static void oreilly_com() throws InterruptedException{
		APP_LOGS.debug("executing search on oreily.com");
		driver.get("http://shop.oreilly.com/");
		String mainWindowHandle=driver.getWindowHandle();
		System.out.println(mainWindowHandle);
		driver.findElement(By.id("q")).sendKeys("Selenium testing tools cookbook");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a.close")).click();
		
		//driver.findElement(By.id("q")).sendKeys("Selenium testing tools cookbook");
		TestBase.waitUntilElementByxpath("//*[@id='search-button']/input");//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='search-button']/input")).click();
		driver.findElement(By.xpath("//img[@src='http://akamaicovers.oreilly.com/images/9781849515740/bkt.gif']")).click();
		String book = driver.findElement(By.xpath(".//*[@id='optionsTable']/tbody/tr/td[1]/div/div[1]/span")).getText();
		System.out.println(book);
	    xls.setCellData("Sheet1", "ActualPrice", 7,book );
		
		String Actual_Price = xls.getCellData("Sheet1", "ActualPrice", 7);
		String Expected_Price = xls.getCellData("Sheet1", "ExpectedPrice", 7);
		System.out.println(Actual_Price);
		System.out.println(Expected_Price);
		
		
		if(Actual_Price.equals(Expected_Price)){
			xls.setCellDataGreen("Sheet1", "Result", 7, "Pass");
			
		}else if(!Actual_Price.equals(Expected_Price)){
			xls.setCellDataRed("Sheet1", "Result", 7, "Fail");
			
			}
			
		}
	

}
