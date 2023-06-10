package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {


    public OpenChartLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);//initialize elements-->it does same logic off driver.findElement
    }

    @FindBy (xpath = "//input[@id='input-username']")
    WebElement username ;
    @FindBy (xpath = "//input[@id='input-password']")
    WebElement password ;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(css = "#alert")
    WebElement errorMessage;


    public void loginFunctionality(String username,String password) throws InterruptedException {
        Thread.sleep(2000);
      this.username.sendKeys(username);
        Thread.sleep(2000);
      this. password.sendKeys(password);
        Thread.sleep(2000);
       loginButton.click();
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
