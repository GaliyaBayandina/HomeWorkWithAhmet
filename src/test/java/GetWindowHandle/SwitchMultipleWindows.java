package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

@Test
public class SwitchMultipleWindows {
    public void switchMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//  driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();

        for (String id : allPages) {
            if (!id.equals(mainPage)) {
                driver.switchTo().window(id);
                break;
            }

        }

        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        BrowserUtils.switchByTitle(driver, "Kickstart");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());
    }


    @Test

        public void realPractice() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
           WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button = driver.findElement(By.xpath("//button[@id='newTabsWindowsBtn']"));
//        System.out.println(button);
//        BrowserUtils.scrollWithJs(driver,button4);
        Thread.sleep(2000);
        BrowserUtils.clickWithJs(driver,button);

        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        System.out.println(driver.getTitle());


         WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
         firstName.sendKeys("Galiya");

         WebElement lastName = driver.findElement( By.xpath("//input[@id='lastName']"));
         lastName.sendKeys("Bayandina");

         WebElement gender = driver.findElement(By.xpath("//input[@id='femalerb']"));
        BrowserUtils.clickWithJs(driver,gender);



        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        BrowserUtils.clickWithJs(driver,language);



        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
         email.sendKeys("bayandinagaliya362@gmail.com");

         WebElement   password = driver.findElement(By.xpath("//input[@id='password']"));
         password.sendKeys("1234567");

        WebElement register = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.clickWithJs(driver,register);


        WebElement message = driver.findElement(By.cssSelector("#msg"));
    String actualMessage = BrowserUtils.getText(message);
    String expectetMessage = "Registration is Successful";
        Assert.assertEquals(actualMessage,expectetMessage);

        BrowserUtils.switchByTitle(driver, "Window Handles");
        WebElement header=driver.findElement (By.xpath(  "//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader, expectedHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");

        WebElement clickMePrompt=driver.findElement (By.cssSelector("#promptBox"));
        BrowserUtils.clickWithJs(driver,clickMePrompt);

        driver.quit();//

    }}