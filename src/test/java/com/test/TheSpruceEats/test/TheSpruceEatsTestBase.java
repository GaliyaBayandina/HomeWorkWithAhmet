package com.test.TheSpruceEats.test;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TheSpruceEatsTestBase {

   public WebDriver driver;
    @BeforeMethod
    public void setup() {
//        WebDriverManager.chromedriver().setup();
//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--remote-allow-origins=*");
//      driver = new ChromeDriver(options);
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       driver.manage().window().maximize();

  driver= DriverHelper.getDriver();
        driver.navigate().to("https://www.thespruceeats.com/");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"thespruceeats");
        }
        driver.quit();
    }

}



