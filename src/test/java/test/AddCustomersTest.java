package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerForm;
import page.DashboardPage;
import page.List_Customer_Page;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomersTest {

	WebDriver driver;
	ExcelReader reader = new ExcelReader("src\\main\\java\\data\\Book1.xlsx");
	String name = reader.getCellData("login", "Username", 2);
	String password = reader.getCellData("login", "Password", 2);
	String fullname = reader.getCellData("AddContactInfo", "FullName", 2);
	String companyname = reader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	String country = reader.getCellData("AddContactInfo", "Country", 2);

	@Test
	public void customersform() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName(name);
		loginPage.insertPassword(password);
		loginPage.submit();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);

		dashboard.clickOnCustomer();
		dashboard.clickOnAddustomerButton();

		AddCustomerForm addcustomer = PageFactory.initElements(driver, AddCustomerForm.class);
		addcustomer.Clickoncustomers();
		addcustomer.Addcustomers();
		addcustomer.FULLNAME(fullname);
		addcustomer.enterCompanyName(companyname);
		addcustomer.emailfield(email);
		addcustomer.Addressfield(address);
		addcustomer.CITYNAME(city);
		addcustomer.ZIPCODE(zip);
		addcustomer.COUNTRYNAME(country);
		addcustomer.ClickOnSubmit();
		addcustomer.CustomerFormValidation();

		List_Customer_Page listcustom = PageFactory.initElements(driver, List_Customer_Page.class);
		listcustom.Listcustomers();
		listcustom.searchonlist();

		addcustomer.varifyEnteredName();

		listcustom.DeleteCustomerConfarmationButton();

	}

}
