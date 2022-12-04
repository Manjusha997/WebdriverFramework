package com.WEBDRIVER_PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//window  handles for gmail

public class Gmail {
	WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S252473503%3A1668003202416128&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=ARgdvAuW3iQrRNpwAERNIwsOEqgZix2N3BHu0LtXVsJbLInvheZitbUN1vex8mv-2zv7d42SaJh5NA");
		Thread.sleep(2000);
		String parentWindow=driver.getWindowHandle();//get the window id
		Thread.sleep(2000);
		System.out.println( "The parent window id is:::"+parentWindow);
	     driver.findElement(By.id("identifierId")).sendKeys("text");
	     Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#recoveryIdentifierId")).sendKeys("Forgotpwd");
		Thread.sleep(2000);
		String childWindow=driver.switchTo().window(parentWindow).getTitle();
		Thread.sleep(2000);
		System.out.println( "the child window is:::"+childWindow+ driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b'] span[class='VfPpkd-vQzf8d']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Help")).click();//new window opening
		Thread.sleep(2000);
		//driver.switchTo().window(parentWindow);
		
		driver.quit();
	}
}
