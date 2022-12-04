package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class OrangehrmTables {

WebDriver driver;
  @Test
  public void tablesInOrangeHrm() throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(2000);
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	  Thread.sleep(2000);
	  Actions ac=new Actions(driver);
	  ac.moveToElement(driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']"))).click();
	  //WebElement empTable=driver.findElement(By.cssSelector("div[role='rowgroup']"));
	 List<WebElement>list=driver.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']"));
	  System.out.println("No of rows are::"+list.size());
	  Thread.sleep(2000);
//	  for (WebElement e : list) {
//		  List<WebElement> column=
		driver.close();
	}
	  
  

  @AfterTest
  public void afterTest() {
	 Reporter.log("After Test", true); 
  }
  

}
