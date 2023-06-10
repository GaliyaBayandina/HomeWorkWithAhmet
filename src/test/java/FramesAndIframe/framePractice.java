package FramesAndIframe;

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
import java.util.List;

public class framePractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");


        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */


        WebElement pavilionLink = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionLink.click();

        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);

        WebElement seleniumDrop = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(seleniumDrop).perform();
        WebElement seleniumPython = driver.findElement(By.linkText("Selenium-Python"));
        seleniumPython.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Selenium-Python')]"));
        Assert.assertEquals(BrowserUtils.getText(header), "Selenium-Python Tutorial");
Thread.sleep(2000);
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for (WebElement link : allLinks) {
            System.out.println(BrowserUtils.getText(link));
        }
        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
        BrowserUtils.switchByTitle(driver, "iframes");
        Thread.sleep(2000);
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By. linkText("Category1"));
        category1.click();

        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives");

        WebElement header2 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header2), "Category Archives: SeleniumTesting");

        List<WebElement> contentHeaders = driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for(WebElement link : contentHeaders){
            System.out.println(BrowserUtils.getText(link));
        }
/*
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */
        BrowserUtils.switchByTitle(driver, "iframes");//this is where my driver pointing driver.switchTo() .frame ( nameOrld: "Framel");
        WebElement text=driver.findElement (By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo() .parentFrame ();
        driver.switchTo () . frame (  "Frame2");
        WebElement category3=driver.findElement (By .linkText ("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,  "Archives");
        WebElement header3=driver.findElement (By.tagName ("h1")) ;
        System.out.println(BrowserUtils.getText(header3));












    }


}