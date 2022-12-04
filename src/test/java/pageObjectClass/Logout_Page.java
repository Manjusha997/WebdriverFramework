package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout_Page {
	WebDriver driver;
	public Logout_Page(WebDriver driver) {
		this.driver=driver;
		}
	
		@FindBy(id="welcome")WebElement clickwelcome;
		@FindBy(xpath ="//a[normalize-space()='Logout']")WebElement clickLogout;
		public void verifiLogout() throws Throwable {
			this.clickwelcome.click();
			Thread.sleep(2000);
			this.clickLogout.click();
			Thread.sleep(2000);
		}
	

}
