package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePge {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Dashboard')]")
	WebElement DashBoard_Header;

	public void validation_Dashboard() {
		Assert.assertEquals(DashBoard_Header.getText(), "Dashboard", "Page not found!");
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement Customers;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")
	WebElement Add_Customer;

	public void clickOnCustomer() {
		waitForElement(driver, 10,Customers);
		Customers.click();
	}
	public void clickOnAddustomerButton() {
		waitForElement(driver, 10,Add_Customer);
		Add_Customer.click();
	}

}