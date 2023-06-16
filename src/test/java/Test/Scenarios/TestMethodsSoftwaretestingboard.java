package Test.Scenarios;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;
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

public class TestMethodsSoftwaretestingboard {
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://magento.softwaretestingboard.com/");
	}

	@Test(priority = 1)
	public void loginUserWithCorrectCredentials() {
		MainPage mainpage = new MainPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		mainpage.clickLinkLogin();
		loginPage.typeEmail("aa@aa.aa");
		loginPage.typePassword("GoodPassword123");
		loginPage.clickButtonSubmit();
		String ActualTitle = driver.getTitle();
		String ActualURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualTitle, "Home Page");
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/");

	}

	@Test(priority = 2)
	public void searchProductByName() {
		MainPage mainpage = new MainPage(driver);
		mainpage.searchProduct("Hoodie");
		String ActualTitle = driver.getTitle();
		String ActualURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualTitle, "Search results for: 'Hoodie'");
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/catalogsearch/result/?q=Hoodie");
	}

	@Test(priority = 3)
	public void addProductToCart() {
		CatalogSearchPage catalogSearchPage = new CatalogSearchPage(driver);
		ProductPage productPage = new ProductPage(driver);
		catalogSearchPage.scrollToFirstItem();
		catalogSearchPage.clickFirstItem();
		String ActualTitle = driver.getTitle();
		String ActualURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualTitle, "Selene Yoga Hoodie");
		AssertJUnit.assertEquals(ActualURL, "https://magento.softwaretestingboard.com/selene-yoga-hoodie.html");
		productPage.clickSize();
		productPage.clickColor();
		productPage.clickButtonAddToCart();
		AssertJUnit.assertTrue(catalogSearchPage.isMessageVisible());
	}

	@Test(priority = 4)
	public void checkoutProcess() {
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
