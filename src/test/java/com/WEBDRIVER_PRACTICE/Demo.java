package com.WEBDRIVER_PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;
	public static void main(String args[]) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		WebElement userName=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.cssSelector("input[placeholder='Password']"));
		if(userName.isDisplayed()&&userName.isEnabled())
		{
			userName.sendKeys("Admin");
			//Thread.sleep(3000);
			if(password.isDisplayed()&& password.isEnabled()) {
				password.sendKeys("admin123");	
				//Thread.sleep(3000);
			}
		}

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.navigate().to("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804944%7Cb%7Cfacebook%20%27%7C&placement=&creative=550525804944&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-327195741349%26loc_physical_ms%3D20453%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIh76Xz-ud-wIVTB0rCh0YtgZbEAAYASAAEgIizvD_BwE");
		Thread.sleep(5000);
		WebElement male=driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		male.click();
		System.out.println("male is selected"+male);
		Thread.sleep(3000);



		driver.quit();










	}











}
