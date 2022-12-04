package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class AutoItForOrangehrm {
	WebDriver driver;
	@Test
	public void uploadScreenshots() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Actions ac=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//pim
		driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")).click();//add employee
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Selenium");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getText();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus']")).click();




		driver.close();

	}
	@AfterTest
	public void afterTest() {
		Reporter.log("After uploding the screenshot from window", true);
	}

}
