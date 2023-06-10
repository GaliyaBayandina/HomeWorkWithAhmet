package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class switchWindowclass {
    @Test
    public void swicthPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        WebElement multipleWindow = driver.findElement(By.xpath("//a[.='Multiple Windows']"));
        multipleWindow.click();

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        System.out.println(driver.getWindowHandle());//main pafeID--.The internet
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        //082FC34B4FFE0F6C434E9F41B8D3642D
        //switch
        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getWindowHandle());
        System.out.println(allPagesId);
        //[082FC34B4FFE0F6C434E9F41B8D3642D, 6E8C17AFA1A7463A2730F81693847D03]
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));


    }

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement newWindow = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJs(driver, newWindow);
        newWindow.click();

        Set<String> allPageId = driver.getWindowHandles();
        String mainPage = driver.getWindowHandle();
        for (String id : allPageId) {
            if (!id.equals(mainPage)) {
                driver.switchTo().window(id);
            }
        }

        WebElement nameAlerts = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(nameAlerts), "AlertsDemo");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
    }

    @Test
    public void practice2Ahmed () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement newWindow = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJs(driver, newWindow);//scroll
        newWindow.click();

       String mainPageID = driver.getWindowHandle();//this is my driver page id
        Set<String> allPagesID = driver.getWindowHandles();//all pages id
        for (String id :allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;

            }

        }

        String actualTitle= driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);

        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement alertBox=driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();





    }


}










//
//
//
//
//        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
//        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo".trim());
//
//        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
//        alertBox.click();
