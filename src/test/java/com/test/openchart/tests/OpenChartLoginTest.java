package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{
    @Test
    public void happyPathLogin() throws InterruptedException {

    OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);

    openChartLoginPage.loginFunctionality("demo","demo");
    Thread.sleep(1000);
    Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
}
@Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage= new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("hjdjfhh", "hgdhhd");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
}
}
