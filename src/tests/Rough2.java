package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium tools cook book");
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//img[@src='http://ecx.images-amazon.com/images/I/51f6vAA-xeL._AA160_.jpg']")).click();
		//List<WebElement> results = driver.findElements(By.xpath("//*[@id='result_0']/div/div/div/div/div/div/a"));
		//System.out.println(results.size());
		//for (int i = 0; i < results.size();i++){
			//Thread.sleep(5000);
			//results.get(0).click();
		
		
			driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
			driver.get("http://www.amazon.com/Selenium-Testing-Cookbook-Gundecha-Unmesh/dp/1849515743/ref=sr_1_1?ie=UTF8&qid=1448998061&sr=8-1&keywords=Selenium+tools+cook+book");
			String ele = driver.findElement(By.xpath("//span[@class='a-color-price']")).getText();
			System.out.println(ele);
			driver.close();
		

	
	}
}


