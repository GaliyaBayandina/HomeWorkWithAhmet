package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("c");

        List<WebElement> links= driver.findElements(By.xpath("//li"))  ;
        int count = 0;
        for (WebElement element:links) {
                Thread.sleep(10);
                System.out.println(element.getText());
                count++;

            }
        System.out.println(count);

int counter2=0;
for (WebElement link:links){
    if (link.getText().length()>=12){
        System.out.println(link.getText().trim());
        counter2++;
    }
}

        System.out.println(counter2);

        }

        }










