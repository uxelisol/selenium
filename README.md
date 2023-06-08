
# selenium tests
selenium tests tests for [softwaretestingboard.com](https://magento.softwaretestingboard.com/).

### Contents
- [Pre-requisite](#Pre-requisite)
- [Technology](#Technology)
- [Allure report](#allure-report)
- [Usage](#Usage)
- [Requirements](#Requirements)
- [File structure](#file-structure)
- [Tests](#Tests)
- [ScreenShots](#ScreenShots)
- [To do](#to-do)

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

 
### Tests
-Verify user registration;
    -click [registration] link
    -fill in name
    -fill in last name
    -fill in email
    -fill in password
    -fill in password confirmation
    -click submit button
-Verify user  login;
    - click [Sign in] link
    -fill in email
    -fill in password
-Verify product search functionality;
    -type to search box product name
    - click search 
    - check  page
-Verify add-to-cart functionality;
    -click to product 
    -click size button
    -click collor button 
    -click [Add to Cart]
    -check message is success
-Verify the checkout process;
    -click  cart
    -click  CheckOut
    -check is page correct 
    -select shipping method
    -click Place Order



### ScreenShots 

![allure result1](https://github.com/uxelisol/selenium/blob/main/allure1.png)
![allure result2](https://github.com/uxelisol/selenium/blob/main/allure2.png)


### To Do
:fix problem with flaky test
