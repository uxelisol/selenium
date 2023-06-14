
# selenium tests
Selenium tests tests for [softwaretestingboard.com](https://magento.softwaretestingboard.com/).

### Contents
- [An overview of the tasks implemented](#An-overview-of-the-tasks-implemented)
- [Description of the POM classes](#Description-of-the-POM-classes)
- [Detailed steps on how to run the tests](#Detailed-steps-on-how-to-run-the-tests)
- [Screenshots of the test results](#Screenshots-of-the-test-results)
- [Pre-requisite](#Pre-requisite)
- [Technology](#Technology)
- [ScreenShots](#ScreenShots)
- [To do](#to-do)

### An overview of the tasks implemented
<ul>
  <li>Verify user registration
    <ul>
      <li>click [registration] link</li>
      <li>fill in name</li>
      <li>fill in email</li>
      <li>fill in password</li>
      <li>fill in password confirmation</li>
      <li>click submit button</li>
    </ul>
  </li>
  <li>Verify user  login
    <ul>
      <li>click [Sign in] link</li>
      <li>fill in email</li>
      <li>fill in password</li>
      <li>check  page is correct </li>
    </ul>
  </li>
  <li>Verify product search functionality
    <ul>
      <li>type to search box product name</li>
      <li>click search </li>
      <li>check  page with products</li>
    </ul>
  </li>
  <li>Verify add-to-cart functionality
    <ul>
      <li>click to product </li>
      <li>click size button</li>
      <li>click collor button </li>
      <li>click [Add to Cart]</li>
      <li>check message is success</li>
    </ul>
  </li>
  <li>Verify the checkout process
    <ul>
      <li>click  cart</li>
      <li>click  CheckOut</li>
      <li>check is page correct </li>
      <li>select shipping method</li>
      <li>click Place Order</li>
    </ul>
  </li>
</ul>

### Description of the POM classes
All classes have the same structure 
CSS locators for interactive elements
```java
	By linkRegistration 	= By.xpath("//a[contains(text(),'Create an Account')]");//header link to registration page
	By linkLogin 			= By.xpath("//a[contains(text(),'Sign In')]");//header link to login page
	By inputSearch 			= By.id("search");// search box
	By buttonSearch			= By.cssSelector("button[title='Search']");//search button 
```
and methods for interaction
```java
  public void clickLinkRegistration()  {
		driver.findElement(linkRegistration).click();
	}//click on registration link
	public void clickLinkLogin()  {
		driver.findElement(linkLogin).click();
	}//click on Sign in link
	public void typeInputSearchProduct(String product)  {
		driver.findElement(inputSearch).sendKeys(product);
	}//type to search box
	public void clickButtonSearch()  {
		driver.findElement(buttonSearch).click();
	}// click search button
```

<ul>
<li>CatalogSearchPage  <i>contains locators: first product in list, message box and method for interaction   </i> </li>
<li>CheckoutPage <i>contains locators: Shipping Method, Next button, Place Order button and method for interaction   </i></li>
<li>LoginPage <i>contains locators: email input,password input, Login button and method for interaction   </i></li>
<li>MainPage <i>contains locators: registration link,Login link, search box, search button, Cart button, Check Out button, Sign Out link		 and method for interaction </i></li>
<li>ProductPage <i>contains locators: size button,color button, Add to Cart button, and method for interaction </i></li>
<li>RegistrationPage <i>contains locators: Name,Last name, Email, Password, Pasword confirmation, Submit button and method for interaction </i></li> 
</ul>

### How to run the tests
 - Open project in Eclipce IDE
 - Right click on testng.xml file -> Rus As -> TestNG Suite
![how_to_run](https://github.com/uxelisol/selenium/blob/main/screenshots/how_to_run.png)

Or:
- open terminal
- Navigate to the project path using cd <project_path>
- Run the following command 

```
java -cp <path of lib>; <path of bin folder>
org.testng.TestNG <path of testng>/testng.xml
```

### Screenshots of the test results.
![allure result1](https://github.com/uxelisol/selenium/blob/main/screenshots/allure1.png)
![allure result2](https://github.com/uxelisol/selenium/blob/main/screenshots/allure2.png)

### Pre-requisite

-   [Allure](https://docs.qameta.io/allure/#_get_started)  
    It may be [classic solutions with java](https://github.com/allure-framework/allure2#download) 
- [Java](https://www.java.com/)

### Technology
- [Java](https://www.java.com/)
- [Selenium](https://www.selenium.dev/)
- [Allure Reporter](https://docs.qameta.io/allure/)
- [Maven](https://maven.apache.org/)
- [TestNG](https://testng.org/doc/)

### Requirements
 :exclamation: To install and run the project, you need [Java ](https://www.java.com/) v1.7.

