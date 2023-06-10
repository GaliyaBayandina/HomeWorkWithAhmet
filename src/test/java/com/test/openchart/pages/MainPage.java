package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement xButton;


    @FindBy(css = "#menu-customer")
    WebElement customerOption;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement customerButton;


    public void GetToCustomersPage() throws InterruptedException {
        xButton.click();
        Thread.sleep(500);
        customerOption.click();
        Thread.sleep(500);
        customerButton.click();
        Thread.sleep(500);


    }
}
