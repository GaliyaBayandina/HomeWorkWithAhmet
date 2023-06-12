package com.test.blaze.test;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeOrderTest extends  BlazeTestBase{
    @Test
    public void validateOrderFunctionality () throws InterruptedException {

        BlazeHomePage blazeHomePage=new BlazeHomePage (driver);
        blazeHomePage.chooseCategory (  "Laptops");
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage (driver);
        laptopsPage.chooseLaptopBrand("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage (driver);
        macBookProPage.clickAddToCartButton(driver, "Product added");
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage = new BlazeCartPage(driver);

        blazeCartPage.clickPlaceOrederButton();
        BlazeOrderPage blazeOrderPage = new BlazeOrderPage(driver);
        blazeOrderPage.OrderFunctionality("Galiya","Kazakstan","Astana","98","25",
                "2023","Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");


    }
    }

