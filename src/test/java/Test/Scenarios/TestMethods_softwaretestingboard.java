package Test.Scenarios;

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
	
	@Test
	public void a_loginUserWithCorrectCredentials() {
		MainPage mainpage = new MainPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		mainpage.clickLinkLogin();
		loginPage.typeEmail("aa@aa.aa");
		loginPage.typePassword("GoodPassword123");
		loginPage.clickButtonSubmit();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, "Home Page", "wrong page title");		
	}
	
	@Test
	public void b_searchProductByName() {
		MainPage mainpage = new MainPage(driver);
		mainpage.searchProduct("Hoodie");
		String ActualTitle = driver.getTitle();
		String ActualURL	 = driver.getCurrentUrl();
		Assert.assertEquals(ActualTitle, "Search results for: 'Hoodie'", "wrong page title");
		Assert.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/catalogsearch/result/?q=Hoodie", "wrong page url");
	}
	
	@Test
	public void c_addProductToCart() {
		CatalogSearchPage catalogSearchPage = new CatalogSearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		catalogSearchPage.clickFirstItem();
		String ActualTitle = driver.getTitle();
		String ActualURL	 = driver.getCurrentUrl();
		Assert.assertEquals(ActualTitle, "Selene Yoga Hoodie");
		Assert.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/selene-yoga-hoodie.html", "wrong page url");
		productPage.clickSize();
		productPage.clickColor();
		productPage.clickButtonAddToCart();
		Assert.assertEquals(catalogSearchPage.isMessageVisible(), true);	
	}
	@Test
	public void d_checkoutProcess() {
		MainPage mainpage = new MainPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		mainpage.clickButtonCart();
		mainpage.clickButtonCheckOut();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, "Checkout");
		checkoutPage.clickFirstShippingMethod();
		checkoutPage.clickButtonNext();
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/checkout/#shipping");
		
	}

	
	

	

	
	
	
	
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
