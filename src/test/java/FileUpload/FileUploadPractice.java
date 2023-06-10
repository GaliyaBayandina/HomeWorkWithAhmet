package FileUpload;

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

public class FileUploadPractice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");


        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/galiyabayandina/Downloads/usa.png");
        Thread.sleep(2000);
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();

        WebElement validatefileName = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName = BrowserUtils.getText(validatefileName);
        String expectedName = "usa.png";
        Assert.assertEquals(actualName, expectedName);
    }


    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");


        WebElement uploadFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        uploadFile.sendKeys("/Users/galiyabayandina/Downloads/usa.png");
        Thread.sleep(2000);
        WebElement uploadedMessage = driver.findElement(By.xpath("//b[contains(text(),'Select file to send(max 196.45 MB)')]"));
        String actualName = BrowserUtils.getText(uploadedMessage);
        String expectedName = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualName, expectedName);
        Thread.sleep(2000);
        WebElement chooseButton = driver.findElement(By.xpath("//input[@id='terms']"));
        BrowserUtils.clickWithJs(driver, chooseButton);
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        clickButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//h3[@id='res']"));
        String actualName2 = BrowserUtils.getText(successMessage);
        String expectedName2 = "has been successfully uploaded.";
        Assert.assertEquals(actualName, expectedName);
        Thread.sleep(2000);

    }
}