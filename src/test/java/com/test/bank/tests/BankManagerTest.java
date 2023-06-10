package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality() {
        //1
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        //2
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60606", "Customer added successfully with customer id");
    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
        //1
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        //2
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60606", "Customer added successfully with customer id");
        //3
        bankManagerPage.openAccountFunctionality(driver, "Ahmet Baldir", "Dollar", "Account created successfully with account Number");


    }

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60606", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver, "Ahmet Baldir", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Ahmet", "Baldir", "60606");
    }



}










