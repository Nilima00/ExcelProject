package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePge {

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public int randomNumber(int bound) {
		Random rdm = new Random();
		int ran = rdm.nextInt(bound);
		return ran;
	}

	public void dropdown(WebElement element, String visibletext) {
		Select sel = new Select(element);

		sel.selectByVisibleText(visibletext);
	}

}
