package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectClass.Emp_Page;
import pageObjectClass.Login_Page;
import pageObjectClass.Logout_Page;

public class Pom_Driver_Script {
WebDriver driver;
@BeforeTest
public void Setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://orangehrm.qedgetech.com/");
	Login_Page login=PageFactory.initElements(driver, Login_Page.class);
 login.verifyLogin("Admin", "Qedge123!@#");
}
@Test
public void Employee() throws Throwable {
	Emp_Page emp=PageFactory.initElements(driver, Emp_Page.class);
	emp.verifyEmp("Testing", "Automation");
}
@AfterTest
public void TearDown() throws Throwable {
	Logout_Page logout=PageFactory.initElements(driver, Logout_Page.class);
	logout.verifiLogout();
	driver.close();
}
}
