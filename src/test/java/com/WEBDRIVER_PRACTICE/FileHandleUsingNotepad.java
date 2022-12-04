package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class FileHandleUsingNotepad {
	WebDriver driver;
	

  @Test
  public void f() throws Throwable {
	  FileReader fr=new FileReader("C:\\Users\\dell\\OneDrive\\Desktop\\File_Handing.txt");
	  BufferedReader br=new BufferedReader(fr);
	  String str=" ";
	  while((str=br.readLine())!=null) {
		  //split the str  data in to ARR
		  String login[]=str.split(",");
		  WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(login[0]);
			  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(login[1]);
			  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			  Thread.sleep(2000);
			  String expected="dashboard";
			  String actual=driver.getCurrentUrl();
			  if(actual.contains(expected)) {
				  System.out.println("Login successful:"+expected+"  "+actual);
				    }
			  else {
				  String msg=driver.findElement(By.xpath("//div[@role='alert']")).getText();
				  System.out.println("Login Failed:"+expected+"  "+actual);	
				 }
			  driver.close();
			  }
	  }
  @AfterTest
  public void afterTest() {
	  Reporter.log("Aftercompletion of test tases", true);
  }

}
