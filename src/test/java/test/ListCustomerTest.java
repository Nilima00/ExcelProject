package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerForm;
import page.DashboardPage;
import page.List_Customer_Page;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class ListCustomerTest {

	WebDriver driver;
	ExcelReader reader = new ExcelReader("src\\main\\java\\data\\Book1.xlsx");
	String name = reader.getCellData("login", "Username", 2);
	String password = reader.getCellData("login", "Password", 2);
	//String fullname = reader.getCellData("AddContactInfo", "FullName", 2);

	@Test
	public void listcustomersform() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName(name);
		loginPage.insertPassword(password);
		loginPage.submit();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);

		AddCustomerForm addcustomer = PageFactory.initElements(driver, AddCustomerForm.class);
		addcustomer.Clickoncustomers();

		List_Customer_Page listcustom = PageFactory.initElements(driver, List_Customer_Page.class);

		listcustom.Listcustomers();
		listcustom.searchonlist();
	
		/*
		 * AddCustomerForm addcustom =
		 * PageFactory.initElements(driver,AddCustomerForm.class );
		 * addcustomer.FULLNAME(fullname);
		 * 
		 * listcustom.varifyEnteredName();
		 */
		listcustom.DeleteCustomerConfarmationButton();

	}
}
