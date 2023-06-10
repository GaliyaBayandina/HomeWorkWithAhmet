package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJsPractice {
    @Test
    public void PracticeBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");

        //1
        WebElement jsAlertPreview=driver.findElement (By.xpath(  " //h5 [contains (text(),'Normal alert')]"));
        jsAlertPreview.click();
        Alert alert=driver.switchTo() .alert();
        System.out.println(alert.getText() .trim());
        Thread. sleep (  2000); alert.accept();
        WebElement htmlPreview=driver.findElement (By.xpath (  " //button [contains (@onclick, 'swal')]")); htmlPreview.click();
        WebElement message=driver.findElement (By.xpath( "//div[@class='swal-modal']"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="something went wrong!";
        Assert.assertTrue(actualMessage.contains (expectedMessage));
        System.out.println(BrowserUtils.getText(message));
    }
}