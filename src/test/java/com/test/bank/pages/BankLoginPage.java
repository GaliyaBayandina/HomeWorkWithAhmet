package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);//initialize elements-->it does same logic off driver.findElement
    }

    @FindBy(css = ".mainHeading")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager')]")
    WebElement managerLogin;

    @FindBy (xpath = "//button[.='Bank Manager Login']")
    WebElement bankManagerLogin;


    public void LoginPageComponentsValidation(String expectedHeader) {
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed() && bankManagerLogin.isEnabled());
    }

    public void clickManagerButton() {
        bankManagerLogin.click();
    }

    public void clickCustomerLoginButton() {
        customerLogin.click();
    }


}
