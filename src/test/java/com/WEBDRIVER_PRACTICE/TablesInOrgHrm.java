package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TablesInOrgHrm {
	WebDriver driver;
	@Test
	public void f() throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/webhp?authuser=1");
		Thread.sleep(2000);
        Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.linkText("Gmail"))).contextClick().perform();
		Thread.sleep(2000);
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_DOWN);
		rc.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		rc.keyPress(KeyEvent.VK_DOWN); 
		rc.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		rc.keyPress(KeyEvent.VK_ENTER);
		ArrayList<String> window=new ArrayList<String>(driver.getWindowHandles());
		System.out.println("The windowIds :::"+window);
		driver.switchTo().window(window.get(0)) ;
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".gb_d[data-pid='2']")).click();
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("Hello world");
		Thread.sleep(2000);
		driver.switchTo().window(window.get(0));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("   Ok google");
		Thread.sleep(2000);
		driver.quit();
	}


	@AfterTest
	public void afterTest() {
		Reporter.log("After test", true);
	}

}
