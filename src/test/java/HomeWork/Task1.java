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

public class Task1 {
    /*
    Navigate to
    "http://secure.smartbearsoftware.com/samples/Te
     stComplete11/WebOrders/Login.aspx?"

     Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"

Validate header is equals to "List of All Orders"

Test Scenario
Test Case -1
     */
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expected = driver.getTitle();
        String actual = "Web Orders Login";
        Assert.assertEquals(expected, actual);

        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Web Orders");
        String expected2 = driver.getTitle();
        String actual2 = "Web Orders";
        Assert.assertEquals(expected2, actual2);
      WebElement PageName = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(PageName);
        String expectedHeader= "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);





    }
}