package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    @Test
    public void PracticeJSAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        //1
        WebElement firstClick= driver.findElement(By.xpath("//button[@id='alertBox']"));
        firstClick.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement message1= driver.findElement(By.xpath("//div[@id='output']"));
        String expectedMessage1="You selected alert popup";
        String actualMessage1= BrowserUtils.getText(message1);
        Assert.assertEquals(expectedMessage1,actualMessage1);
        //2
        WebElement secondClick= driver.findElement(By.xpath("//button[@id='confirmBox']"));
        secondClick.click();
        alert.dismiss();
        WebElement mesage2= driver.findElement(By.xpath("//div[@id='output']"));
        String actualM2= BrowserUtils.getText(mesage2);
        String expected2="You pressed Cancel in confirmation popup";
        Assert.assertEquals(expected2,actualM2);
       //3
        WebElement thirdClick=driver.findElement(By.xpath("//button[@id='promptBox']"));
        thirdClick.click();
        alert.sendKeys("Buket");
        alert.accept();
        WebElement message3= driver.findElement(By.cssSelector("#output"));
        String actualP=BrowserUtils.getText(message3);
        String expectedP="You entered text Buket in prompt popup";
        Assert.assertEquals(actualP,expectedP);
    }
}