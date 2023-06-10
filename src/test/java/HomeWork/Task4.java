package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
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
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(product, "ScreenSaver", "value");
        WebElement quanity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quanity.sendKeys("5");
        Thread.sleep(2000);
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        Thread.sleep(2000);
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys("Des Plaines");
        Thread.sleep(2000);
        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys("Illinois");
        Thread.sleep(2000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCode.sendKeys("60018");
        Thread.sleep(2000);
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        Thread.sleep(2000);
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(2000);
        WebElement experationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        experationDate.sendKeys("03/24");
        Thread.sleep(2000);
        WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        process.click();
        Thread.sleep(2000);
        WebElement successmessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successmessage.isDisplayed());
        WebElement allOrders = driver.findElement(By.linkText("View all orders"));
        BrowserUtils.clickWithJs(driver, allOrders);
        Thread.sleep(2000);
        List<WebElement> allOredrs = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "06/03/2023",
                "2200 E devon", "Des Plaines", "Illinois",
                "60018", "MasterCard", "444993876233", "03/24");
        for (int i = 1; i < actualList.size(); i++) {
            actualList.add(allOredrs.get(i).getText());
            if (allOredrs.get(i).getText().equals("03/24")) {
                break;
            }
            System.out.println(actualList);
            Assert.assertEquals(actualList, expectedList);
        }
    }
}

