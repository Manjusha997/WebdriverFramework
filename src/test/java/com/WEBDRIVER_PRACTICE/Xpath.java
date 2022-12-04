package com.WEBDRIVER_PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	WebDriver driver;
  @Test
  public void f() throws Throwable {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(2000);
	  Actions ac=new Actions(driver);
	  ac.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin").perform();
	
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

	  ac.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().perform();
	  Thread.sleep(2000);
	  ac.moveToElement(driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"))).click().perform();
	  Thread.sleep(2000);
	System.out.println(  driver.switchTo().defaultContent().getTitle());
	
	  //ac.moveToElement(driver.findElement(By.xpath("//div[@class='oxd-table-body oxd-card-table-body']"))).click().perform();
	  //Thread.sleep(2000);
	  driver.close();
  } 
  @AfterTest
  public void After() {
	  Reporter.log("After test", true);
  }
  
  }

