package AnnotationsInTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Read_DATA_FROM_EXCEL {

WebDriver driver;
@BeforeTest
public void setup() throws Throwable{ 
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	Thread.sleep(2000);
	
}
  @Test
  public void Login() throws Throwable {
 FileInputStream fi=new FileInputStream("C:\\Users\\dell\\OneDrive\\Desktop\\DataDrivenFiles\\Calculation percentage.xlsx");
 Workbook wb=WorkbookFactory.create(fi);
 Sheet ws=wb.getSheetAt(0);
 Row r=ws.getRow(0);
 //count no of rows
 int rc=ws.getLastRowNum();
 Reporter.log("no of rows in the sheet::"+rc, true);
 for(int i = 1;i<=rc;i++) {
	 driver.get("https://www.calculator.net/percent-calculator.html");
	 Thread.sleep(3000);
 if(wb.getSheet("Calculation").getRow(i).getCell(0).getCellType()==CellType.NUMERIC) {
	 int c1=(int) wb.getSheet("Calculation").getRow(i).getCell(0).getNumericCellValue();
	 //converting integer type to string type data
	 String Percentage=String.valueOf(c1);
	 
	 if(wb.getSheet("Calculation").getRow(i).getCell(1).getCellType()==CellType.NUMERIC) {
		 int c2=(int) wb.getSheet("Calculation").getRow(i).getCell(1).getNumericCellValue();
		 //converting integer type to string type data
		 String amount=String.valueOf(c2);
		 driver.findElement(By.id("cpar1")).sendKeys(Percentage);
		 driver.findElement(By.xpath("(//input[@id='cpar2'])[1]")).sendKeys(amount);
		 driver.findElement(By.xpath("//input[@type='image']")).click();
		 //capture the result in xml file
		 String Result=driver.findElement(By.xpath("//p[@class='verybigtext']")).getText();
		 ws.getRow(i).createCell(2).setCellValue(Result);
		 Reporter.log(Percentage+"  "+amount+"  "+Result,true );
		 
  }
  }
}fi.close();
FileOutputStream fo=new FileOutputStream("C:\\Users\\dell\\OneDrive\\Desktop\\DataDrivenFiles\\CalResult.xlsx");
wb.write(fo);
fo.close();
wb.close();
  }
  @AfterTest
  public void teardown() {
driver.close();

}
}

  	
  

	



	


 
	 
	  
  

  
