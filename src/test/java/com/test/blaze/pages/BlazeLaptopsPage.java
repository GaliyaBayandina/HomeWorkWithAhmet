package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeLaptopsPage {
    public BlazeLaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hrefch")
    List<WebElement> allLaptops;

    public void chooseLaptopBrand(String brand) throws InterruptedException {

        for (WebElement laptop : allLaptops) {
            Thread.sleep(1000);
            if (BrowserUtils.getText(laptop).equals(brand)) {
                laptop.click();
                break;

            }
        }
    }

}

