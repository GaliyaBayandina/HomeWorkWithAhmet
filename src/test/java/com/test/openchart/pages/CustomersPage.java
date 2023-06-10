package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomersPage {

    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addCustomerButton;
    @FindBy(css = "#input-firstname")
    WebElement addFirstName;
    @FindBy(css = "#input-lastname")
    WebElement addLastName;
    @FindBy(css = "#input-email")
    WebElement addEmail;
    @FindBy(css = "#input-password")
    WebElement addPassword;
    @FindBy(css = "#input-confirm")
    WebElement addConfirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newsletterSlide;
    @FindBy(css = "#input-safe")
    WebElement safeSlider;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;
    @FindBy(css = ".alert")
    WebElement alertMessage;


    public void AddClickCustomer() throws InterruptedException {
        addCustomerButton.click();
        Thread.sleep(500);

    }

    public void ProvideCustomerInformation(WebDriver driver, String firstName, String lastName, String email, String password, String confirmPassword) throws InterruptedException {
        addFirstName.sendKeys(firstName);
        addLastName.sendKeys(lastName);
        addEmail.sendKeys(email);
        addPassword.sendKeys(password);
        addConfirmPassword.sendKeys(confirmPassword);
        BrowserUtils.scrollWithJs(driver, newsletterSlide);
        Thread.sleep(2000);
        BrowserUtils.clickWithJs(driver, newsletterSlide);
        BrowserUtils.clickWithJs(driver, safeSlider);
        Thread.sleep(1000);
        BrowserUtils.scrollWithJs(driver,saveButton);
        BrowserUtils.clickWithJs(driver,saveButton);

        Assert.assertEquals(BrowserUtils.getText(alertMessage),"Warning: You do not have permission to modify customers!");

    }


}
