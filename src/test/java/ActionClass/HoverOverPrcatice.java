package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOverPrcatice {
    @Test
    public void  prcaticeMoveToElement () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();

        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class ='product k-listview-item']"));
        List<WebElement>  allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement>  allPrice = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> products = new HashMap<>();
        for   (int i=0;i<allImages.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            products.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrice.get(i)));
        }
        System.out.println(products);

    }
}