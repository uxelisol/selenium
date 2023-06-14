package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By sizeMOption			= By.id("option-label-size-143-item-168");
	By colorBlueOption		= By.id("option-label-color-93-item-56");
	By buttonAddToCart		= By.cssSelector("button[title='Add to Cart']");
	
	public void clickSize() {
		driver.findElement(sizeMOption).click();
	}
	public void clickColor()  {
		 driver.findElement(colorBlueOption).click();
	}
	public void clickButtonAddToCart()  {
		 driver.findElement(buttonAddToCart).click();
	}
	
}
