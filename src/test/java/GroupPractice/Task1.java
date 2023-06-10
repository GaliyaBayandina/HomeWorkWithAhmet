package GroupPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {
    @Test
    public void contextClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");

        WebElement menu = driver.findElement (By.xpath(  " / /i [@class='hm-icon nav-sprite']"));
        menu.click();
        WebElement books = driver.findElement (By.xpath(  " / /a[@data-menu-id='14' ]"));
        BrowserUtils.scrollWithJs(driver,books);
        Thread.sleep (  2000);
        books.click();
        Thread.sleep(  2000);
        WebElement kindleBook = driver.findElement (By.xpath( " / /ul [@data-menu-id= '14]//a[.='Kindle Books']"));
        BrowserUtils.scrollWithJs(driver,kindleBook);
        Thread.sleep (  1000); kindleBook.click();


    }
}