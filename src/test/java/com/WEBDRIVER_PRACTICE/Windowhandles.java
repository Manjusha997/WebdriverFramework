package com.WEBDRIVER_PRACTICE;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles {
	private static final String Terms = null;
	WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S2097800397%3A1667998073089670&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=ARgdvAurNRPHac-IMkGA44TyURdrn1RytGZATtArTay3vXTgvx9EH_8Gwec82Kb6U-WcUoTg9fGx");
		Thread.sleep(5000);
		String parentWindowId=driver.getWindowHandle();
		System.out.println("The parent window id is ::"+parentWindowId);
		//create links on parent child
		driver.findElement(By.linkText("Help")).click();
		//driver.findElement(By.className("promoted-search__input")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Privacy")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Terms")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Learn more")).click();

		//print multiple windows id's opened in parent window
		Set<String>allwindowsId=driver.getWindowHandles();
		System.out.println("Display all WINDOWSID IS:"+allwindowsId);
		//ITERATE ALL WINDOW IDS using for each loop 
		for(String childWindow:allwindowsId)
		{
			String childTitle=driver.switchTo().window(childWindow).getTitle();
			Thread.sleep(2000);
			System.out.println("page title is: "+childTitle );
			//driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(parentWindowId).getTitle();//switch back to parent window
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#identifierId")).sendKeys("test");
			Thread.sleep(5000);
			driver.quit();

		}
	}
}
