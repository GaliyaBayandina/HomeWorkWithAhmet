package FramesAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");




        driver.switchTo().frame("frame-top");
        //Name or ID iframe
        WebElement iframeleft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver .switchTo().frame(iframeleft);
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(bottom));


        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
       WebElement middle = driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));

        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-right");//right frame
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

        //CAN YOU PRINT OUT BUTTOM
//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main html

        driver.switchTo().defaultContent();//--->this go to the HTML no matter what


        //SWITCHING FRAME WITH INDEX
        driver.switchTo().frame(1);//Bottom

        WebElement bottom1 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom1));



    }
}