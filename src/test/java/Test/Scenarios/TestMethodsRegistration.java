package Test.Scenarios;

import org.testng.annotations.Test;

import Util.Helpers;

import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.MainPage;
import objects.RegistrationPage;


public class TestMethodsRegistration {
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://magento.softwaretestingboard.com/");
	}

	@Test
	public void registerNewUser() {
		MainPage mainpage = new MainPage(driver);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		mainpage.clickLinkRegistration();
		Helpers helper = new Helpers();
		String email = helper.getString() +"@gmail.com" ;
		System.out.println(email);
		registrationPage.fillForm("SomeName", "Last", email, "VeryStrongPass123");
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "My Account");
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
