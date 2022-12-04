package DriverFactory;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class DataDrivenScript {
	WebDriver driver;
	String inputpath="D:\\AUTOMATION_SELENIUM\\Webdriver\\TestInput\\Login.xlsx";
	String outputpath="D:\\AUTOMATION_SELENIUM\\Webdriver\\TestOutput\\DataDrivenResults.xlsx";
	ExtentReports reports;
	ExtentTest test;
	Properties config;
 
  @BeforeTest
  public void beforeTest() {
	  //define path to generate reports
	  reports=new ExtentReports("./Webdriver/Datadriven.html");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test
  public void VerifyLogin() throws Throwable,FileNotFoundException{
	  config=new Properties();
	  config.load(new FileInputStream("D:\\AUTOMATION_SELENIUM\\Webdriver\\proprtity\\Login.properties"));
	  //creating refrence object for excel methods which is created in excel file utils class
	  ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	  
	  //count no of rows in a sheet
	  int rc=xl.rowCount("Login");
	  Reporter.log("no of rows are::"+rc,true);
	  for(int i=1;i<=rc;i++) {
		  test=reports.startTest("Validatelogin");
		  driver.get(config.getProperty("Url"));
		  //read cell data from excel
		  String username=xl.getCellData("Login", i, 0);
		  String password=xl.getCellData("Login", i, 1);
		  driver.findElement(By.xpath(config.getProperty("Username"))).sendKeys(username);
		  driver.findElement(By.xpath(config.getProperty("Password"))).sendKeys(password);
		  driver.findElement(By.xpath(config.getProperty("Loginbutton"))).click();
		  String expected="dashboard";
		  String actual=driver.getCurrentUrl();
		  if(actual.contains(expected)) {
			  //write as login success into results  cell
			  xl.setCellData("Login", i, 2, "LoginSucess", outputpath);
			//writing status as pass in cell
			  xl.setCellData("Login", i, 3, "Pass", outputpath);
			  test.log(LogStatus.PASS, "Login success::"+expected+"   "+actual);
			  Reporter.log("Login success::"+expected+"  "+actual,true);
			   }
		  else {
			  File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(screen, new File("./Screen/Iteration/"+i+"Loginpage.png"));
			  String errormsg=driver.findElement(By.xpath(config.getProperty("Invalidmsg"))).getText();
			  //write as login fail into results  cell
			
			  xl.setCellData("Login", i, 2, "Error message", outputpath);
			//writing status as fail in cell
			  xl.setCellData("Login", i, 3, "Fail", outputpath);
			  
			  test.log(LogStatus.FAIL, "Login fail::"+expected+"   "+actual);
			  Reporter.log("Login fail::"+expected+"  "+actual,true);
		  }
		  reports.endTest(test);
		  reports.flush();
	  }
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
