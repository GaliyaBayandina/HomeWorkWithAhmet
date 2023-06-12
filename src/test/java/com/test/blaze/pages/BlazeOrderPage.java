package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeOrderPage {
    public BlazeOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement card;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;


    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement message;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void OrderFunctionality(String name, String country, String city,
                                        String card, String month, String year, String expectedMessage) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);

        purchaseButton.click();
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        okButton.click();
        Thread.sleep(500);





    }



}
