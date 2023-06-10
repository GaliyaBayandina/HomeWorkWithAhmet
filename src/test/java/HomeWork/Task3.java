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
import java.util.List;

public class Task3 {

    /*
    Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button


Find the links for
View all orders
View all products
Orders


Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"

     */
    @Test
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");


        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);

        WebElement allOrders=driver.findElement(By.xpath(  "//a[.='View all orders' ]"));
        WebElement allProducts=driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orders=driver.findElement(By.xpath(  "//a[.= 'Order']"));

        String value1 = allOrders.getAttribute("href");
        String value2 = allProducts.getAttribute("href");
        String value3 = orders.getAttribute ("href");


        Assert.assertTrue(value1.contains("Default.aspx"));
        Assert.assertTrue(value2.contains("Products.aspx"));
        Assert.assertTrue(value3.contains("Process.aspx"));

    }
}
