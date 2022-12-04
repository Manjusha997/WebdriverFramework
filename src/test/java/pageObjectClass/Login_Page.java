package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page {
WebDriver driver;
public Login_Page(WebDriver driver) {
	this.driver=driver;
}
@FindBy(name="txtUsername")WebElement Username;
@FindBy(name="txtPassword")WebElement password;
@FindBy(name="Submit")WebElement loginbutton;
public void verifyLogin(String Username,String Password) {
	this.Username.sendKeys(Username);
	password.sendKeys(Password);
	loginbutton.click();
	
	
}

}
