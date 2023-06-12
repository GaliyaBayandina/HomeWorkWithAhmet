package com.test.TheSpruceEats.test;

import com.test.TheSpruceEats.pages.FishAndSeaFoodPage;
import com.test.TheSpruceEats.pages.FishForDinnerPage;
import com.test.TheSpruceEats.pages.HomePage;
import org.testng.annotations.Test;

public class FishForDinnerTest extends TheSpruceEatsTestBase{
    @Test
    public void FishForDinnerTest() throws InterruptedException {


        HomePage homePage = new HomePage(driver);
        homePage.chooseCategory(driver,"Fish & Seafood");

        FishAndSeaFoodPage fishAndSeaFoodPage = new FishAndSeaFoodPage(driver);
        fishAndSeaFoodPage.FindRecipe(driver,"Fish for dinner");

        FishForDinnerPage fishForDinnerPage = new FishForDinnerPage(driver );
        fishForDinnerPage.validateRecipeName(driver,"6-Ingredient Roasted Salmon Fillets");

    }
}
