package com.test.TheSpruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

/*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients tab --> choose Fish&SeaFood option

3-ScrollDown to the search bar (Use JS Method)
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver

PURPOSE: *Apply Action class method
         *Apply How to find the unique element for real website
         *Apply JS scroll Method
         *Apply TestNG Assertion(validation)
         *Getting used to UI real interview question types
 */


    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsButton;
    @FindBy(xpath = "//li[@class='global-nav__list-item js-global-nav-item'][3]//li")
    List<WebElement> meals;

    public void chooseCategory(WebDriver driver, String name) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(ingredientsButton).perform();

        for (WebElement option : meals){
            Thread.sleep(500);
            if (BrowserUtils.getText(option).equals(name.toUpperCase())) {
               actions.click(option).perform();
                Thread.sleep(2000);
                break;
            }



    }


}}