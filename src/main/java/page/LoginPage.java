package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this. driver= driver;
	}
	
	

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USERNAME;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign in')]")
	WebElement SIGNIN_BUTTON;
	
	public void insertUserName(String name) {
		USERNAME.sendKeys(name);
	}
	
	public void insertPassword(String psw) {
		 PASSWORD.sendKeys(psw);
	}
	
	public void submit() {
		 SIGNIN_BUTTON.click();
		}
	

}
