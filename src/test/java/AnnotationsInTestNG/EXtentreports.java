package AnnotationsInTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EXtentreports {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void beforeTest() {

		reports=new ExtentReports("./webdriver/repots.html");
	}
	@BeforeMethod
	public void setup() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);

	}

	@Test

	public void PassTest() {
		//test.setDescription("Hello");
		test=reports.startTest("My test is pass");
		test.assignAuthor("manjushaqa");
		String expected="google";
		String actual=driver.getTitle();
		System.out.println("the title is match::"+actual);

	}
	@AfterMethod
	public void afterTest() {
		reports.flush();
		reports.endTest(test);
		driver.close();
	}

}
