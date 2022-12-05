package Constant;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PBConstant {
public static WebDriver driver;
public static Properties config;

@BeforeSuite
public void setup() throws Throwable {
	config=new Properties();
	config.load(new FileInputStream("D:\\AUTOMATION_SELENIUM\\Webdriver\\proprtity\\primus.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	else {
		Reporter.log("browser value not matching::",true);
	}

}@AfterSuite
public void Teardown() {
	driver.close();
}
}
