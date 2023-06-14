package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	By inputFirstName = By.id("firstname");
	By inputLastName = By.id("lastname");
	By inputEmail = By.cssSelector("main input[name='email']");
	By inputPassword = By.cssSelector("main input[name='password']");
	By inputPasswordConfirmation = By.cssSelector("main input[name='password_confirmation']");
	By buttonSubmit = By.cssSelector("button[type='submit'].submit");

	public void typeFirstName(String firstname) {
		driver.findElement(inputFirstName).sendKeys(firstname);
	}

	public void typeLastName(String lastname) {
		driver.findElement(inputLastName).sendKeys(lastname);
	}

	public void typeEmail(String email) {
		driver.findElement(inputEmail).sendKeys(email);
	}

	public void typePassword(String password) {
		driver.findElement(inputPassword).sendKeys(password);
	}

	public void typePasswordConfirmation(String passwordConfirmation) {
		driver.findElement(inputPasswordConfirmation).sendKeys(passwordConfirmation);
	}

	public void clickButtonSubmit() {
		driver.findElement(buttonSubmit).click();
	}

	public void fillForm(String firstname, String lastname, String email, String password) {
		typeFirstName(firstname);
		typeLastName(lastname);
		typeEmail(email);
		typePassword(password);
		typePasswordConfirmation(password);
		clickButtonSubmit();

	}
}
