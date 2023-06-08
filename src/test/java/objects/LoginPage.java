package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 
	By inputEmail			= By.id("email");
	By inputPassword		= By.id("pass");
	By buttonSubmit			= By.id("send2");
	
	public void typeEmail(String email)  {
 		driver.findElement(inputEmail).sendKeys(email);
 	}
    public void typePassword(String password)  {
 		driver.findElement(inputPassword).sendKeys(password);
 	}
    public void clickButtonSubmit()  {
		driver.findElement(buttonSubmit).click();
	}
	
	
}
