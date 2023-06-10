package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPrcatice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options. addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");




        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        Thread.sleep(1000);



        WebElement closeBtn = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeBtn.click();
        Thread.sleep(1000);


        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.quit();
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("DEMO");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);


        WebElement alarmMes=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(alarmMes.getText().trim(),"No match for Username and/or Password.");

        /*
        WebElement errorMessage=driver.findElement(By.cssSelector("#alert"));
        String actualMessage=errorMessage.getText().trim();
        String expectedMessage="No match for Username and/or Password."
        Assert.assertEquals (actualMessage, expectedMessage);
         */

    }
    @Test
    public void validateProductsButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement closeSmallwindo = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeSmallwindo.click();

        WebElement DashBoredButton=driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        DashBoredButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());
        Assert.assertTrue(productsButton.isEnabled());
    }
    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement closeSmallwindo = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeSmallwindo.click();
        WebElement DashBoredButton=driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        DashBoredButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i = 1; i<boxes.size(); i++){
            Thread.sleep(2000);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertTrue(!boxes.get(i).isSelected());
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);


            List<WebElement> allProducts = (List<WebElement>) driver.findElement(By.xpath("//td[@class='text-start'"));
            List<String> actualProductOrder= new ArrayList<>();
            List<String> expectedProductOrder= new ArrayList<>();
            for(int j=1;j<allProducts.size();j++){
                actualProductOrder.add(allProducts.get(j).getText().toLowerCase().trim());//same order same item
                expectedProductOrder.add(allProducts.get(j).getText().toLowerCase().trim());//same order same item
            }
            Collections.sort(expectedProductOrder);
            System.out.println(actualProductOrder);
            System.out.println(expectedProductOrder);
            Assert.assertEquals(actualProductOrder,expectedProductOrder);
            }


        }
    }

    /*
TEST CASE:

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */







