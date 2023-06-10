package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {
    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button



Validate "View all products" is selected


Validate header is equals to "List of Products"
Validate the url has "Products" keyword
     */

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);
        WebElement allProducts = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        System.out.println(allProducts.getText());
        allProducts.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        System.out.println(driver.getCurrentUrl());
        String url = driver.getCurrentUrl();
       String actualUrl= "Products";
       String expectedUrl = driver.getCurrentUrl();
    Assert.assertTrue(expectedUrl.contains(actualUrl));
/*
Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"

Validate the url has "Products" keyword
     */

    }
}
