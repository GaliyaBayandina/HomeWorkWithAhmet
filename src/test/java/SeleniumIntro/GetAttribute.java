package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeApoitment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeApoitment.click();

        WebElement getName = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(getName.getText());
        System.out.println( getName.getAttribute("value"));//John Doe
        System.out.println(getName.getAttribute("type"));//TEXT
        driver.quit();


    }
}
