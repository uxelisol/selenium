package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CatalogSearchPage {

	WebDriver driver;

	public CatalogSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By buttonFirstProduct = By.xpath("//ol/li");
	By message = By.cssSelector("div[role='alert']");

	public void clickFirstItem() {
		driver.findElement(buttonFirstProduct).click();
	}

	public boolean isMessageVisible() {
		return driver.findElement(message).isDisplayed();
	}
	
	public void scrollToFirstElement() {
		new Actions(driver)
        .scrollToElement(driver.findElement(buttonFirstProduct))
        .perform();
	}

}
