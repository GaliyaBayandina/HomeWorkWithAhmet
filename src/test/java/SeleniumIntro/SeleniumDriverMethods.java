package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {
    //driver.get()
//driver.manage.windows.maximize()
//driver.getTitle()
//driver.getCurrentUrl()
//driver.navigate. to ()
//driver.navigate.refresh()
//driver.navigate.back()
//driver.navigate.forward()
//driver.getPageSource ()
//driver.close ()
//driver.quit ()
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();//it maximize screen
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);//pauses system for certain time 3 second
driver.navigate().to("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();//it will go to GOOGLE again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.navigate().forward();//it willl gp to youtube again
        System.out.println(driver.getTitle()    );
        Thread.sleep(3000);

        driver.navigate().refresh();//it refreshes the page
        Thread.sleep(3000);

        driver.getPageSource();//it gets the HTML structure of page on console
        System.out.println(driver.getPageSource());
        driver.quit();//it closes the all pages opened from  one automation

    }
}
