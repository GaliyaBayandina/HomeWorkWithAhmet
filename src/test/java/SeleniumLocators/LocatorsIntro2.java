package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/galiyabayandina/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "False");

        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        driver.navigate().back();
        WebElement link = driver.findElement(By.linkText("Selenium"));//it has tagname and text
        link.click();
        WebElement selenium =driver.findElement(By.tagName("h1"));
        String actualSelenium = selenium.getText().trim();
        String expectedSelenium = "Selenium automates browsers. That's it!";
        System.out.println(actualSelenium.equals(expectedSelenium) ? "Correct" : "False");



        driver.navigate().back();
        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumber1 = driver.findElement(By.tagName("h1"));
        String actualCucumber = cucumber1.getText().trim();
        String expectedCucumber = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumber.equals(expectedCucumber) ? "Correct" : "False");

        driver.navigate().back();
        WebElement  testNg= driver.findElement(By.linkText("TestNG"));
        testNg.click();
        WebElement test = driver.findElement(By.tagName("h2"));
        String actualTest = test.getText().trim();
        String expectedNg = "TestNG";
        System.out.println(actualTest.equals(expectedNg) ? "Correct" : "False");

        driver.navigate().back();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "file:///Users/galiyabayandina/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "Correct": "False");
        javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();



        //LOCATOR PARTIALLINKTEXT
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());


    }

}


















