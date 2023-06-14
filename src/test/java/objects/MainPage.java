package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	By linkRegistration = By.xpath("//a[contains(text(),'Create an Account')]");
	By linkLogin = By.xpath("//a[contains(text(),'Sign In')]");
	By inputSearch = By.id("search");
	By buttonSearch = By.cssSelector("button[title='Search']");
	By buttonCart = By.cssSelector("div[data-block]");
	By buttonCheckOut = By.id("top-cart-btn-checkout");
	By toggleMenu = By.cssSelector("header button[data-action='customer-menu-toggle']");
	By linkSignOut = By.cssSelector("header .customer-menu .authorization-link a");

	public void clickLinkRegistration() {
		driver.findElement(linkRegistration).click();
	}

	public void clickLinkLogin() {
		driver.findElement(linkLogin).click();
	}

	public void typeInputSearchProduct(String product) {
		driver.findElement(inputSearch).sendKeys(product);
	}

	public void clickButtonSearch() {
		driver.findElement(buttonSearch).click();
	}

	public void searchProduct(String product) {
		typeInputSearchProduct(product);
		clickButtonSearch();
	}

	public void clickButtonCart() {
		driver.findElement(buttonCart).click();
	}

	public void clickButtonCheckOut() {
		driver.findElement(buttonCheckOut).click();
	}

	public void clickToggleMenu() {
		driver.findElement(toggleMenu).click();
	}

	public void clickLinkSignOut() {
		driver.findElement(linkSignOut).click();
	}

}
