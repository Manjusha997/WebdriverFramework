package CommonFuction;

import java.awt.Desktop.Action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBConstant;

public class FunctionLibrary extends PBConstant{
	public static boolean VerifyLogin(String Username,String password) throws Throwable {
		driver.findElement(By.xpath(config.getProperty("objUsername"))).sendKeys(Username);
		driver.findElement(By.xpath(config.getProperty("objpassword"))).sendKeys(password);
		driver.findElement(By.xpath(config.getProperty("objLoginbutton"))).click();
		Thread.sleep(2000);
		String expected="adminflow";
		String actual=driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase())) {
			Reporter.log("login success::"+expected+"  "+actual, true);
			return true;
		}
			else {
				Reporter.log("LoginFailure::"+expected+"  "+actual, true);
				return false;
			} 
			}
	//method for click branch
	public static void clickbranches() throws Throwable {
	
		
driver.findElement(By.xpath(config.getProperty("objBranches"))).click();
		Thread.sleep(2000);
	}
	//method for branch creation
	public static boolean VerifyNewBranch(String bname,String Address1,String Address2,String Address3,String Area,String zip,String country,String state,String city) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("objnewbranch"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(config.getProperty("objbranchname"))).sendKeys(bname);
		driver.findElement(By.xpath(config.getProperty("objAddress1"))).sendKeys(Address1);
		driver.findElement(By.xpath(config.getProperty("objAddress2"))).sendKeys(Address2);
		driver.findElement(By.xpath(config.getProperty("objAddress3"))).sendKeys(Address3);
		driver.findElement(By.xpath(config.getProperty("objArea"))).sendKeys(Area);
		driver.findElement(By.xpath(config.getProperty("objZipcode"))).sendKeys(zip);
		new Select(driver.findElement(By.xpath(config.getProperty("objcountry")))).selectByVisibleText(country);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(config.getProperty("objstate")))).selectByVisibleText(state);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(config.getProperty("objcity")))).selectByVisibleText(city);
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.getProperty("objsubmit"))).click();
		//capture alert msg
		String expectedalert=driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String actualalert="New branch with";
		if(expectedalert.toLowerCase().contains(actualalert.toLowerCase())){
			Reporter.log("Branch creation success:: "+expectedalert+"   "+actualalert,true);
			return true;
			}
		else {
			Reporter.log("Branch creation Fail:: "+expectedalert+"   "+actualalert,true);
			return false;	
		}
	}
	
//method for Update branch
	public static boolean VerifyBranchUpdate(String brname,String address1,String zipcode) throws Throwable {
		//click on edit button
		driver.findElement(By.xpath(config.getProperty("editbtn"))).click();
		Thread.sleep(2000);
		WebElement branchname=driver.findElement(By.xpath(config.getProperty("objBranch")));
		branchname.clear();
		branchname.sendKeys(brname);
		WebElement Add=driver.findElement(By.xpath(config.getProperty("objAddress")));
		Add.clear();
		Add.sendKeys(address1);
		WebElement Objzipcode=driver.findElement(By.xpath(config.getProperty("objZip")));
		Objzipcode.clear();
		Objzipcode.sendKeys(zipcode);
		driver.findElement(By.xpath(config.getProperty("objupdate"))).click();
		//capture alert
		String expectedupdatealert=driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String actualupdatealert="Branch updated";
		if(expectedupdatealert.toLowerCase().contains(actualupdatealert.toLowerCase())){
			Reporter.log("Branch Updated success:: "+expectedupdatealert+"   "+actualupdatealert,true);
			return true;
			}
		else {
			Reporter.log("Branch Updated Fail:: "+expectedupdatealert+"   "+actualupdatealert,true);
			return false;	
		}
		}
	//method for verify Role 
	public static void clickRoleButn() throws Throwable {
		driver.findElement(By.xpath(config.getProperty("objRolebtn"))).click();
	Thread.sleep(2000);
	}
	//method for verifyRoleInsertion 
		public static boolean VerifyNewRoleCreation(String rname,String rdesc,String roletype) throws Throwable {
			driver.findElement(By.xpath(config.getProperty("objnewrole"))).click();
			driver.findElement(By.xpath(config.getProperty("objRolename"))).sendKeys(rname);
			driver.findElement(By.xpath(config.getProperty("objRoledep"))).sendKeys(rdesc);
			new Select(driver.findElement(By.xpath(config.getProperty("objroletype")))).selectByVisibleText(roletype);
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("objsubmitbutn"))).click();
			Thread.sleep(2000);
			//capture alert msg of role
			String expectedalertrole=driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			String actualalertrole="New Role";
			if(expectedalertrole.toLowerCase().contains(actualalertrole.toLowerCase())){
				Reporter.log("Role creation success:: "+expectedalertrole+"   "+actualalertrole,true);
				return true;
				}
			else {
				Reporter.log("Role creation Fail:: "+expectedalertrole+"   "+actualalertrole,true);
				return false;	
			}
		}
//		method for updateing role
		public static  boolean VerifyroleUpdate(String Updaeroletype) throws Throwable {
			driver.findElement(By.xpath(config.getProperty("objRolebtn"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("objedit"))).click();
			Thread.sleep(2000);
			WebElement roleupdate=driver.findElement(By.xpath(config.getProperty("updateroletype")));
			//roleupdate.clear();//if u pass this stmt we get invalid state element exception
			roleupdate.sendKeys(Updaeroletype);
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("objupdaterole"))).click();
			String exproleupdatealert=driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			String actualroleupdatealert="Role updated";
			if(exproleupdatealert.toLowerCase().contains(actualroleupdatealert.toLowerCase())) {
				Reporter.log("Role update success:: "+exproleupdatealert+"   "+actualroleupdatealert,true);
				return true;
				}
			else {
				Reporter.log("Role update Fail:: "+exproleupdatealert+"   "+actualroleupdatealert,true);
				return false;	
			}
			}
		
//	method for logout
	public static boolean Verifylogout() throws Throwable {
		driver.findElement(By.xpath(config.getProperty("objLogout"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(config.getProperty("objLoginbutton"))).isDisplayed()){
			Reporter.log("Admin Logout Sucessful", true);
			return true;
		}
	else {
		Reporter.log(" Admin Logout Fail::",true);
		return false;	
		}
	}
//	method for data genaration
	public static String generateDate() {
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("YYYY_MM_DD_hh_mm_ss");
		return df.format(date);
	}
}

