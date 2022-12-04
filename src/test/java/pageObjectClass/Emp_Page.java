package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Emp_Page {
	WebDriver driver;
	public Emp_Page(WebDriver driver ) {
		this.driver=driver;
	}

	@FindBy(xpath = "//b[normalize-space()='PIM']")WebElement clickpim;
	@FindBy(id = "btnAdd")WebElement clickAdd;
	@FindBy(xpath = "//input[@id='firstName']")WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName']")WebElement lastname ;
	@FindBy(id = "btnSave")WebElement  clicksave;
	public void verifyEmp(String firstname,String lastname) throws Throwable {
		this.clickpim.click();
		Thread.sleep(2000);
		this.clickAdd.click();
		Thread.sleep(2000);
		this.firstname.sendKeys(firstname);
		Thread.sleep(2000);
		this.lastname.sendKeys(lastname);
		Thread.sleep(2000);
		this.clicksave.click();
		Thread.sleep(2000);
	}
	
}
