package com.WEBDRIVER_PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class faceBook {
	WebDriver driver;
public static void main(String args[]) throws Throwable {
WebDriverManager.chromedriver().setup();
 WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
 driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804944%7Cb%7Cfacebook%20%27%7C&placement=&creative=550525804944&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-327195741349%26loc_physical_ms%3D20453%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIh76Xz-ud-wIVTB0rCh0YtgZbEAAYASAAEgIizvD_BwE");
 Thread.sleep(2000);
 String parent=driver.getWindowHandle();
 System.out.println(driver.getTitle());
 driver.findElement(By.name("firstname")).sendKeys("lanka");
 Thread.sleep(2000);
 driver.findElement(By.name("lastname")).sendKeys("test");
 Thread.sleep(2000);
 driver.findElement(By.name("reg_email__")).sendKeys("test@gmail.com");
 Thread.sleep(2000);
	/*
	 * //hidden elment reenter email not working tis element boolean
	 * value=driver.findElement(By.name("(//input[@id='u_6_j_/W'])")).isDisplayed();
	 * //boolean value=variable.isEnabled(); //value.sendKeys("test@gmail.com");
	 * Thread.sleep(2000);
	 */
 driver.findElement(By.id("password_step_input")).sendKeys("Test@132");
 Thread.sleep(2000);
 driver.findElement(By.id("birthday-help"));
 Thread.sleep(2000);
 Select day=new Select(driver.findElement(By.id("day")));
 day.selectByIndex(0);
 Thread.sleep(2000);
 Select month =new Select(driver.findElement(By.id("month")));
 month.selectByVisibleText("Mar");
 Thread.sleep(2000);
 Select year=new Select(driver.findElement(By.id("year")));
 year.selectByValue("2018");
 Thread.sleep(2000);
 driver.findElement(By.className("_58mt")).click();
 driver.findElement(By.name("websubmit")).click();
 Thread.sleep(2000);
 
 WebElement link=driver.findElement(By.id("non-users-notice-link"));
 link.click();
 //Thread.sleep(2000);
 driver.navigate().back();
 System.out.println(driver.getTitle());
driver.close();
}

}
