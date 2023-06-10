package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import org.testng.annotations.Test;

public class BankCustomerLoginPageTest extends  BankTestBase{
    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60606", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver, "Ahmet Baldir", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Ahmet", "Baldir", "60606");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
       CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.customerLoginFunctionality("Ahmet Baldir", "Welcome Ahmet Baldir !!");
        customerLoginPage.depositFunctionality("500","Deposit Successful");
        customerLoginPage.withDrawFunctionality("300","Transaction successful");
       customerLoginPage.transactionFunctionality();

       //


    }



























//    @Test
//    public void validateCustomerFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//        BankLoginPage loginPage = new BankLoginPage(driver);
//        loginPage.clickManagerButton();
//        BankManagerPage bankManagerPage = new BankManagerPage(driver);
//        bankManagerPage.addCustomerFunctionality(driver, "Nazgul", "Jumanova", "11229", "Customer added succasfully");
//
//        bankManagerPage.openAccountFunctionality(driver, "Nazgul Jumanova", "Dollar",
//                "Account created successfully with account Number");
//        bankManagerPage.customersFunctionality("Nazgul", "Jumanova", "11229");
//    }
//    @Test
//    public void validatingRemainingBalance() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//        BankLoginPage loginPage = new BankLoginPage(driver);
//        loginPage.clickManagerButton();
//        BankManagerPage bankManagerPage = new BankManagerPage(driver);
//        bankManagerPage.addCustomerFunctionality(driver, "", "", "", "Customer added successfully with customer id");
//        bankManagerPage.openAccountFunctionality(driver, "", "", "Account created successfully with account Number");
//        bankManagerPage.customersFunctionality("", "", "");
//        bankManagerPage
//        BankCustomerLoginPage bankCustomerLoginPage = new BankCustomerLoginPage(driver);
//        bankCustomerLoginPage.clickCustomerButton();
//        bankCustomerLoginPage.customerLoginFunctionality();
//        bankCustomerLoginPage.validatingHeader("Welcome  !!");
//        bankCustomerLoginPage.depositButton("500");
//        bankCustomerLoginPage.validatingPossitiveDepositMessage("Deposit Successful");
//        bankCustomerLoginPage.withdrawButton("300");
//        bankCustomerLoginPage.validatingPossitiveWithdrawMessage("Transaction successful");
//        bankCustomerLoginPage.transactionButton();
//        BankCustomerTransactionPage bankCustomerTransactionPage = new BankCustomerTransactionPage(driver);
//        bankCustomerTransactionPage.validatingBalance("500","300","200");
//        driver.quit();
//    }
//

}
