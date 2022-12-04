package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class IRTC {
	 WebDriver driver;
	 @BeforeTest
	  public void beforeTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);	 
	  }

  @Test
  public void Irtc() throws Throwable {
	  Actions ac=new Actions(driver);
	  //Thread.sleep(3000);	 
	  String windows=driver.getWindowHandle();
	  System.out.println("The  Parent WIndow iD is:::"+windows);
//	  opening child windows 
	  driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();
	  ac.moveToElement(driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']"))).click().perform();
	  ac.moveToElement(driver.findElement(By.xpath("//a[@aria-label='Menu Hotels. Website will be opened in new tab']"))).click().perform();
	  
//	  get the collection of window id
	  ArrayList<String>windowCollection= new ArrayList<String>(driver.getWindowHandles());
	  System.out.println("THe collection of windowIds of child::"+windowCollection.size());
	  System.out.println("The List of Child Window Ids:::"+windowCollection);
//	  list of windowIds usoing foe each loop
	  for (String e : windowCollection) {
		System.out.println(e);
	
//	  comparing parent window to child window IDS
	  if(!windows.equals(e)) {
		  String child=driver.switchTo().window(e).getTitle();
		  System.out.println(child);
		  Thread.sleep(2000);
		  driver.close();
		  }
	  }
	  driver.switchTo().window(windowCollection.get(0));
//	  get the collection of frames in the webpage
	  List<WebElement>frames=driver.findElements(By.id("google_ads_iframe_/37179215/GPT_NWEB_HOME_TOP1_0"));
	  System.out.println("NO of fraes in the webpage is:::"+frames.size());
//	  switch to particular id
	  driver.switchTo().frame(4);
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  driver.switchTo().window(windowCollection.get(0));
	  Thread.sleep(2000);
	  driver.close();
	  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("Running after TEst",true);
  }

}
