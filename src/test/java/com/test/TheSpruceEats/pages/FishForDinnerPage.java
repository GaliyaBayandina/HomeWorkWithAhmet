package com.test.TheSpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishForDinnerPage {
    WebDriver driver;

    public FishForDinnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy (css = "#starRating_score_4Star")
    WebElement starRating;
    @FindBy (css = "#pop_search_editor")
    WebElement editorChoice;


    @FindBy (xpath = "//span[contains(text(),'6-Ingredient Roasted Salmon Fillets')]")
    WebElement salmonRecipe;

    public void validateRecipeName (WebDriver driver, String expectedName) throws InterruptedException {
        BrowserUtils.clickWithJs(driver,starRating);
        Thread.sleep(500);

        BrowserUtils.clickWithJs(driver,editorChoice);
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(salmonRecipe),expectedName);

        }
}
