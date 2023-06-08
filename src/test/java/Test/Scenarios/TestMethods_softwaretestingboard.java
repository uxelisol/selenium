package Test.Scenarios;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.CatalogSearchPage;
import objects.CheckoutPage;
import objects.LoginPage;
import objects.MainPage;
import objects.ProductPage;
import objects.RegistrationPage;

public class TestMethods_softwaretestingboard {
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
	
	@Test public void a_registerNewUser() {
		MainPage mainpage = new MainPage(driver);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		mainpage.clickLinkRegistration();
		registrationPage.fillForm("SomeName", "Last", "astta@asd.com", "VeryStrongPass123");
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "My Account", "wrong page title");	
		mainpage.clickToggleMenu();
		mainpage.clickLinkSignOut();
		
	}
	@Test
	public void b_loginUserWithCorrectCredentials() {
		MainPage mainpage = new MainPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		mainpage.clickLinkLogin();
		loginPage.typeEmail("aa@aa.aa");
		loginPage.typePassword("GoodPassword123");
		loginPage.clickButtonSubmit();
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "My Account", "wrong page title");		
	}
	@Test
	public void c_searchProductByName() {
		MainPage mainpage = new MainPage(driver);
		mainpage.searchProduct("Hoodie");
		String ActualTitle = driver.getTitle();
		String ActualURL	 = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualTitle, "Search results for: 'Hoodie'", "wrong page title");
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/catalogsearch/result/?q=Hoodie", "wrong page url");
	}
	
	@Test
	public void d_addProductToCart() {
		CatalogSearchPage catalogSearchPage = new CatalogSearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		catalogSearchPage.clickFirstItem();
		String ActualTitle = driver.getTitle();
		String ActualURL	 = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualTitle, "Selene Yoga Hoodie");
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/selene-yoga-hoodie.html", "wrong page url");
		productPage.clickSize();
		productPage.clickColor();
		productPage.clickButtonAddToCart();
		AssertJUnit.assertEquals(catalogSearchPage.isMessageVisible(), true);	
	}
	@Test
	public void e_checkoutProcess() {
		MainPage mainpage = new MainPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		mainpage.clickButtonCart();
		mainpage.clickButtonCheckOut();
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "Checkout");
		checkoutPage.clickFirstShippingMethod();
		checkoutPage.clickButtonNext();
		String ActualURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/checkout/#shipping");
		
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
