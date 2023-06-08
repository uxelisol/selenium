
# selenium tests
selenium tests tests for [softwaretestingboard.com](https://magento.softwaretestingboard.com/).

### Contents
- [An overview of the tasks implemented](#An-overview-of-the-tasks-implemented)
- [Pre-requisite](#Pre-requisite)
- [Technology](#Technology)
- [Allure report](#allure-report)
- [Usage](#Usage)
- [Requirements](#Requirements)
- [File structure](#file-structure)
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
      <li>click [Sign in] link/li>
      <li>fill in email</li>
      <li>fill in password</li>
      <li>check  page is correct </li>
    </ul>
  </li>
  <li>Third item
    <ul>
      <li>Indented item</li>
      <li>Indented item</li>
      <li>Indented</li>
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

### Allure report

-   It is generated on every test run


### Usage
- Download project
- Go to root folder
- 


### Requirements
 :exclamation: To install and run the project, you need [Java ](https://www.java.com/) v11.

### File structure
- src    
    - test 
        - java
            - objects
                -CatalogSearchPage.java 
                -CheckoutPage.java
                -LoginPage.java
                -MainPage.java
                -ProductPage.java
                -RegistrationPage.java
            - Test
                -Scenarios
                    -TestMethods_softwaretestingboard.java


   

`Test` folder contains step definitions
`objects` folder contains Page Object Model files

### ScreenShots 

![allure result1](https://github.com/uxelisol/selenium/blob/main/allure1.png)
![allure result2](https://github.com/uxelisol/selenium/blob/main/allure2.png)


### To Do
:fix problem with flaky test
