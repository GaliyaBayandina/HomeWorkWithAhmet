package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Galiya");
        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Bayandina");
        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.id("sex-1"));
        gender.click();
        Thread.sleep(2000);
        WebElement experience = driver.findElement(By.id("exp-4"));
        experience.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("04/11/1998");
        Thread.sleep(2000);
        WebElement manTest = driver.findElement(By.id("profession-0"));
        manTest.click();
        Thread.sleep(2000);
        WebElement autTest = driver.findElement(By.id("profession-1"));
        autTest.click();
        Thread.sleep(2000);
        WebElement tools = driver.findElement(By.id("tool-2"));
        tools.click();
        Thread.sleep(2000);
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Europe");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expUrl)?"URL PASSED":"URL FAILED");

        driver.quit();
    }
}
