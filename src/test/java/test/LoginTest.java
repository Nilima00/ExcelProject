package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	ExcelReader reader = new ExcelReader("src\\main\\java\\data\\Book1.xlsx");
	String name = reader.getCellData("login", "Username", 2);
	String password = reader.getCellData("login", "Password", 2);

	@Test
	public void validlogInUser() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName(name);
		loginPage.insertPassword(password);
		loginPage.submit();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validation_Dashboard();

	}

	// @Test
	public void invalidlogInUser() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName(name);
		loginPage.insertPassword(password);
		loginPage.submit();

	}

}
