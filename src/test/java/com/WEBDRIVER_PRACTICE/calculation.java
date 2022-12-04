package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class calculation {
	WebDriver driver;
  @BeforeMethod
  public void beforeTest() throws Throwable {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("http://calc.qedgetech.com/");
	  Thread.sleep(3000);
  }
  @Test(priority = 2)
  public void addition() throws Throwable {
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("3452");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='+']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("6547");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='=']")).click();
	  Thread.sleep(3000);
	  Reporter.log("Executing the Addition operation sucessfully", true);
	  
  }
  @Test(priority=1,enabled =false)
  public void Subtraction() throws Throwable {
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("3452");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='-']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("6547");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='=']")).click();
	  Thread.sleep(3000);
	  Reporter.log("Executing the subtraction operation sucessfully", true);
	  
  }
  @Test(priority=0)
  public void Multiplication() throws Throwable {
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("3452");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='x']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='display']")).sendKeys("6547");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='=']")).click();
	  Thread.sleep(3000);
	  Reporter.log("Executing the multiplication operation sucessfully", true);
	  
  }
  @AfterMethod
  public void afterTest() {
	  driver.close();
	  Reporter.log("After executing the  sucessfuly", true);
  }

}
