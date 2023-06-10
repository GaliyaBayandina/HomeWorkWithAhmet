package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        WebElement clickButton = driver.findElement(By.xpath("//button"));
        clickButton.click();

        List<WebElement> checkboxes= driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement box:checkboxes){
            if(box.getAttribute("aria-checked").equals("false")){
                box.click();

            }
        }













/*
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement checkbox : checkboxes){
            if (checkbox.getAttribute("aria-checked").equals("false")){
                checkbox.click();
            }
        }
        */


    }}
