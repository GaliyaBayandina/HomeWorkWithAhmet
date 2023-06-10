package KubaMentoring;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Task1 {
    public void TC_01(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/droppable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.xpath(""));
        WebElement dropDown= driver.findElement(By.cssSelector(""));
        BrowserUtils.selectBy(dropDown,"0","index");

        List<WebElement> allNames=driver.findElements(By.xpath(""));
        List<WebElement> allEmails= driver.findElements(By.xpath(""));

        for(int i=0; i<allNames.size();i++){
            TreeMap<String,String> map= new TreeMap<>();
            map.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allEmails.get(i)));
            System.out.println(map);
        }
    }
}

