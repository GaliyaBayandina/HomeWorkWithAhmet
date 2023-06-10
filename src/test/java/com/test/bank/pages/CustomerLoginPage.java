package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerLoginPage {

    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#userSelect")
    WebElement yourName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawalButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement withdrawAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitWithDrawButton;
    @FindBy(xpath = "//strong[.='200']")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;


    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withDrawDebit;


    //    @FindBy(xpath = "//strong[contains(text(),'200')]")
//    WebElement totalBalance;
//@FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
//    WebElement successfulWithdrawMsg;

    public void customerLoginFunctionality(String customerName, String expectedHeader ) throws InterruptedException {
        BrowserUtils.selectBy(yourName, customerName, "text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }

    public void depositFunctionality(String depositAmount, String expected) throws InterruptedException {
        depositButton.click();
        Thread.sleep(2000);
        amount.sendKeys(depositAmount);
        submitDepositButton.submit();
        Assert.assertEquals(BrowserUtils.getText(successMessage), expected);


    }

    public void withDrawFunctionality(String withDrawalAmount, String expectedWithDrawMessage) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(2000);
        withdrawAmount.sendKeys(withDrawalAmount);
        submitDepositButton.click();
        Assert.assertEquals(BrowserUtils.getText(successMessage), expectedWithDrawMessage);

    }
    public void transactionFunctionality () throws InterruptedException {
        int actualBalance = Integer.parseInt(BrowserUtils.getText(balance));//200
        Thread.sleep(2000);
        transactionButton.click();
      //  BrowserUtils.clickWithJs(driver,transactionButton);
        int expectedBalance = (Integer.parseInt(BrowserUtils.getText(depositCredit))-
                Integer.parseInt(BrowserUtils.getText(withDrawDebit)));

        Assert.assertEquals(actualBalance,expectedBalance);

    }
}