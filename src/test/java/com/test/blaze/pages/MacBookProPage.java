package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h2[contains(text(),'MacBook Pro')]")
    WebElement header;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;
    @FindBy(xpath = "//div[@id='myTabContent']")
    WebElement description;
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCartButton;



    public void macBookProInformation(String expectedHeader,String expectedPrice, String expectedDescription) {
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description),expectedDescription);
    }
    public void clickAddToCartButton(WebDriver driver,String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        Thread.sleep(1000);
        alert.accept();
    }

}
