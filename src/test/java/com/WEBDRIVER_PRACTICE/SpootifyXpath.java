package com.WEBDRIVER_PRACTICE;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SpootifyXpath {
	WebDriver driver;
  @Test
  public void SpootifyLoginForm() throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.spotify.com/in-en/free/?utm_source=in-en_brand_contextual_text&utm_medium=paidsearch&utm_campaign=alwayson_asia_in_premiumbusiness_core_brand_neev+contextual+in-en+google&gclid=EAIaIQobChMItcj9_Pys-wIVz3wrCh1Wngq5EAAYASAAEgICX_D_BwE&gclsrc=aw.ds");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[@class='mh-header-secondary mh-tier-2 svelte-vf0pv9'])[1]")).click();
	driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("test@gmail.com");
	driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("test@gmail.com");
	//create pwd
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test123432");
	//username
driver.findElement(By.xpath("//input[@type='email']//following::input[3]")).sendKeys("Testing");
//year
driver.findElement(By.xpath("//input[@type='email']//following::input[4]")).sendKeys("2003");
Thread.sleep(2000);

//month
driver.findElement(By.xpath("//select[@id='month']//option[4]")).click();
Thread.sleep(2000);
//Day
driver.findElement(By.xpath("//input[@type='email']//following::input[5]")).sendKeys("21");
//driver.findElement(By.xpath("//p[@id='onetrust-policy-text']"))
////from here not working
//genderF
driver.findElement(By.xpath("//label[@for='gender_option_female']//span[@class='Indicator-hjfusp-0 iGJrKq']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//label[@class='Label-cpoq-0 dsmGdr']//span[@class='Indicator-sc-1airx73-0 ihUlHW'][1]")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("(//span[@class='Indicator-sc-1airx73-0 ihUlHW'])[2]")).click();
Thread.sleep(2000);


driver.close();
  }
  @AfterTest
  public void afterTest() {
	  Reporter.log("After form filling", true);
  }

}
