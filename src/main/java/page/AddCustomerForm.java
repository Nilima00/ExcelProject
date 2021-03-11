package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerForm extends BasePge {
	WebDriver driver;

	public AddCustomerForm(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement Customers;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")
	WebElement Add_Customer;

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement Fullname;

	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL;

	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS;

	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY;

	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP;

	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY;

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SUBMIT;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Contacts')]") 
	WebElement AddCustomer_validation;

	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")
	WebElement Search_button_onListCustomerPage;

	String enteredfullname;

	public void Clickoncustomers() {
		waitForElement(driver, 30, Customers);
		Customers.click();
	}

	public void Addcustomers() {
		waitForElement(driver, 30, Add_Customer);
		Add_Customer.click();
	}

	public void FULLNAME(String name) {
		waitForElement(driver, 10, Fullname);
		int ran = randomNumber(999);
		enteredfullname = name + ran;
		Fullname.sendKeys(enteredfullname);
	}

	public void enterCompanyName(String companyName) {

		dropdown(COMPANY, companyName);
	}

	public void emailfield(String email) {
		int ran = randomNumber(999);
		EMAIL.sendKeys(ran + email);
	}

	public void Addressfield(String address) {

		ADDRESS.sendKeys(address);
	}

	public void CITYNAME(String city) {

		CITY.sendKeys(city);
	}

	public void ZIPCODE(String Zip) {
		ZIP.sendKeys(Zip);

	}

	public void COUNTRYNAME(String Country) {
		waitForElement(driver, 30, COUNTRY);
		dropdown(COUNTRY, Country);
	}

	public void ClickOnSubmit() {
		waitForElement(driver, 10, SUBMIT);
		SUBMIT.click();}
	
	public void CustomerFormValidation() {
		waitForElement(driver, 30, AddCustomer_validation);
		
		Assert.assertEquals(AddCustomer_validation.getText(),"Contacts" , "Page not found!");
	}
	
	

	public void varifyEnteredName() {

		String before = "//tbody/tr[";
		String after = "]/td[3]";

		for (int i = 1; i <= 15; i++) {
			String name = driver.findElement(By.xpath(before + i + after)).getText();

			waitForElement(driver, 30, Search_button_onListCustomerPage);

			System.out.println(name);
			// Assert.assertEquals(name, Cfullname);
			if (name.contains(enteredfullname)) {
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[7]/a[2]/i[1]")).click();

			}

		}

	}

}
