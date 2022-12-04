package AnnotationsInTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCount {
	WebDriver driver;
	@BeforeMethod
	public void beforetest() throws Throwable {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://primusbank.qedgetech.com/");
	Thread.sleep(2000);
	}
  @Test(priority = 0,description = "primusIBank" )
  public void primusIBank() throws Throwable {
 driver.findElement(By.xpath("(//img[@height='27'])[3]")).click();
	  
	  Thread.sleep(3000);
	  Reporter.log("primusIBank is executed sucessfully", true);
	  
  }
  @Test(priority=1,invocationCount = 2, description = "primusCBank")
  public void primusCBank() throws Throwable {
	 
	  driver.findElement(By.xpath("(//img[@height='27'])[4]")).click();

	  Thread.sleep(3000);
	  Reporter.log("primusCBank is executed sucessfully", true);
	
  }
  

@AfterMethod
public void afterTest() {
	driver.close();
	Reporter.log("After executing the operation sucessfully", true);
}
}