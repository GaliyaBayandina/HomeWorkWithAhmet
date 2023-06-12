package com.test.TheSpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishAndSeaFoodPage {
    WebDriver driver;

    public FishAndSeaFoodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy (css = "#search-form-input")
    WebElement searchBox ;
    @FindBy (css = "#button_1-0")
    WebElement searchButton;


    public void FindRecipe(WebDriver driver,  String recipeName) throws InterruptedException {
        BrowserUtils.scrollWithJs(driver,searchBox);
        searchBox.sendKeys(recipeName);
        Thread.sleep(2000);
        //searchButton.click();
        BrowserUtils.clickWithJs(driver, searchButton);
    }
}
