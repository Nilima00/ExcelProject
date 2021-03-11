package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class List_Customer_Page extends BasePge {
	WebDriver driver;
	String enteredfullname;

	public List_Customer_Page(WebDriver driver) {
		this.driver = driver;
	}

	
	  @FindBy(how = How.XPATH, using = "//a[@id='activity']") WebElement
	  Customer_Activity;
	 

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")
	WebElement List_Customer;

	@FindBy(how = How.XPATH, using = "//body/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement Addcustomer_button_onList_CustomerPage;

	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")
	WebElement Search_button_onListCustomerPage;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement DeleteConfirmationButton;

	/*
	 * public void Activity() { waitForElement(driver, 30, Customer_Activity);
	 * Customer_Activity.click(); }
	 */

	public void Listcustomers() {
		waitForElement(driver, 60, Customer_Activity );
		List_Customer.click();
	}


	public void searchonlist() {
		waitForElement(driver, 60, Addcustomer_button_onList_CustomerPage);
		Search_button_onListCustomerPage.click();
	}

	
	 // public void FULLNAME(String name) {
	  
	//  int ran = randomNumber(999); enteredfullname = name + ran;
	 // Fullname.sendKeys(enteredfullname); 
	 // waitForElement(driver, 30,Fullname ); }
	  
	  public void varifyEnteredName() {
	  
	  String before = "//tbody/tr["; String after = "]/td[3]";
	  
	  for (int i = 1; i <= 5; i++) { String name =
	  driver.findElement(By.xpath(before + i + after)).getText(); // }
	  
	  if (name.contains(enteredfullname)) {
	  driver.findElement(By.xpath("//tbody/tr[" + i +
	  "]/td[7]/a[2]/i[1]")).click();
	  
	  } } }
	 
	
	  public void DeleteCustomerConfarmationButton() { 
		  waitForElement(driver, 30,  DeleteConfirmationButton);
		  DeleteConfirmationButton.click(); }
	 
}
