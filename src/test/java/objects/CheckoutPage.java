package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By firstShippingMethod = By.cssSelector("table tr:first-child td input[type='radio']");
	By buttonNext = By.cssSelector("#shipping-method-buttons-container button[type='submit']");
	By buttonPlaceOrder = By.xpath("//span[contains(text(),'Place Order')]");

	public void clickFirstShippingMethod() {
		driver.findElement(firstShippingMethod).click();
	}

	public void clickButtonNext() {
		driver.findElement(buttonNext).click();
	}

}
