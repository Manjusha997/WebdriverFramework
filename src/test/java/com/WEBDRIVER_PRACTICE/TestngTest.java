package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestngTest {
	WebDriver driver;
	@BeforeTest
	public void Beforetest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get("http://primusbank.qedgetech.com/");
		  Thread.sleep(3000);
	}
  @Test(priority=0,invocationCount = 3)
  public void primusIBank() throws Throwable {
	  
	  driver.findElement(By.xpath("(//img[@height='27'])[3]")).click();
	  
	  Thread.sleep(3000);
	  Reporter.log("primusIBank is executed sucessfully", true);
	  
  }
  @Test(priority=1)
  public void primusCBank() throws Throwable {
	 
	  driver.findElement(By.xpath("(//img[@height='27'])[4]")).click();

	  Thread.sleep(3000);
	  Reporter.log("primusCBank is executed sucessfully", true);
	
  }
  @AfterTest
  public void afterTest() throws Throwable {
	  Thread.sleep(3000);
	  driver.close();
	 
	  Reporter.log("After executing the testcases", true);
  }

}
