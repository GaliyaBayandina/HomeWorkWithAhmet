package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class JSPractice {
    @Test
    public void JSPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/radio-button");

        WebElement yesBtn = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        // yesBtn.click();
        Actions actions = new Actions(driver);
        actions.click(yesBtn).perform();
        WebElement message = driver.findElement(By.cssSelector(".mt-3"));

        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage, expectedMessage);

        WebElement noRadioButtom = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButtom.isEnabled());


    }

    @Test
    public void ScrollintoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.techtorialacademy.com/");
      WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView (true)",findCourse);
      Thread.sleep(2000);
      findCourse.click();

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement copyright = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", copyright);
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(copyright), "Copyright © 2023");

        WebElement applyNow = driver.findElement(By.xpath("//strong[.='APPLY NOW']"));
        js.executeScript("arguments[0].scrollIntoView(true)", applyNow);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", applyNow);

        Assert.assertEquals(js.executeScript("return document.title"), "Apply Now");

        List<WebElement> headers = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> actualHeaders = new ArrayList<>();
        List<String> expectedHeaders = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i = 0; i < headers.size(); i++) {
            actualHeaders.add(BrowserUtils.getText(headers.get(i)));
            Assert.assertEquals(BrowserUtils.getText(headers.get(i)), expectedHeaders.get(i));

        }
        }
    @Test
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

     WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        System.out.println(copyRight.getText().trim());
        BrowserUtils.scrollWithJs(driver,copyRight);


        //VALIDATE
        String actualText = BrowserUtils.getText(copyRight);
        String expectedTest = "Copyright © 2023";
        Assert.assertEquals(actualText,expectedTest);

        WebElement applyNow = driver.findElement(By.linkText("Apply Now"));
        BrowserUtils.scrollWithJs(driver,copyRight);
        BrowserUtils.clickWithJs(driver,copyRight);

        String actualTitle = BrowserUtils.getTitleWithJs(driver);
        String expectedTitle = "Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);


        List<WebElement> allInformation= driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        //List<String> expectedInfromation = new ArrayList<>();
        List<String> expectedInfromation = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInfromation.get(i));
        }



    }
}