package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.youtube.com/");

        //Thread.sleep(2000)
        //song.sednKeys(Keys.ARROW_DOWN)-->inside of loop
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber");

        WebElement button = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        button.click();

        // keys.ENTER


        Thread.sleep(2000);
        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song : songs) {
            if (song.getAttribute("title").equals("Justin Bieber - Baby ft. Ludacris")) {
                Thread.sleep(2000);

                song.sendKeys(Keys.ARROW_DOWN);//SCROLL DOWN


                song.click();
                break;
            }
        }


    }
}
