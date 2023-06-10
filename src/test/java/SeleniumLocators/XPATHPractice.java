package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Galiya");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Bayandina");

        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
        Email.sendKeys("bayandinagaliya3962@gmail.com");

        WebElement telephone= driver.findElement(By.xpath("//input[@id='input-telephone']"));
       telephone.sendKeys("777777");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123456789galiya");

        WebElement passwordConfirm= driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("123456789galiya");

        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        WebElement submitButton=driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader= header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)? "PASSED":"FAILED");
        WebElement submitButton2 =driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton2.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");
        driver.close();
    }
}