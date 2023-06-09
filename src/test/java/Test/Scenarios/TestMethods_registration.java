package Test.Scenarios;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.MainPage;
import objects.RegistrationPage;

public class TestMethods_registration {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	@Test 
	public void a_registerNewUser() {
		MainPage mainpage = new MainPage(driver);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		mainpage.clickLinkRegistration();
		registrationPage.fillForm("SomeName", "Last", "kk@asd.com", "VeryStrongPass123");
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "My Account");			
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
