package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {


    public class OpenCharTestNGPractice {
        @Test
        public void successfulLogin() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("demo");
            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();
            Thread.sleep(2000);
            String title = driver.getTitle();
            String expected = "Dashboard";
            Assert.assertEquals(title, expected);
        }

        @Test
        public void Negative() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username1 = driver.findElement(By.xpath("//input[@name='username']"));
            username1.sendKeys("demo");
            WebElement password1 = driver.findElement(By.xpath("//input[@name='password']"));
            password1.sendKeys("DEMO");
            WebElement button1 = driver.findElement(By.xpath("//button[@type='submit']"));
            button1.click();
            Thread.sleep(2000);
            WebElement MISS = driver.findElement(By.cssSelector("alert"));
            String actual = MISS.getText().trim();
            String expected = "No match for Username and/or Password.";
            Assert.assertEquals(actual, expected);

        }

        @Test
        public void validateProductButton() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("demo");
            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();
            Thread.sleep(2000);
            WebElement submit = driver.findElement(By.cssSelector(".btn-close"));
            submit.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(3000);
            WebElement product = driver.findElement(By.linkText("Products"));
            Assert.assertTrue(product.isDisplayed());
            Assert.assertTrue(product.isEnabled());
        }

        @Test
        public void validatebox() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("demo");
            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();
            Thread.sleep(2000);
            WebElement submit = driver.findElement(By.cssSelector(".btn-close"));
            submit.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(3000);
            WebElement product = driver.findElement(By.linkText("Products"));
            product.click();
            List<WebElement> allbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
            for (int i = 1; i < allbox.size(); i++) {
                Thread.sleep(2000);
                Assert.assertTrue(allbox.get(i).isDisplayed());
                Assert.assertTrue(allbox.get(i).isEnabled());
                Assert.assertFalse(allbox.get(i).isSelected());//as default, it should not be selected
                allbox.get(i).click();
                Assert.assertTrue(allbox.get(i).isSelected());//this one should be selected
                allbox.get(i).sendKeys(Keys.ARROW_DOWN);
            }
        }

        @Test
        public void validateProductNameFunctionalityAscending() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("demo");
            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();
            Thread.sleep(2000);
            WebElement submit = driver.findElement(By.cssSelector(".btn-close"));
            submit.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(3000);
            WebElement product = driver.findElement(By.linkText("Products"));
            product.click();
            Thread.sleep(2000);
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
                    Assert.equals(actualList,expected-list)
 */
            WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
            productName.click();
            List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
            ArrayList<String> actualData = new ArrayList<>();
            ArrayList<String> expectedData = new ArrayList<>();
            for (int i = 1; i < allProducts.size(); i++) {
                actualData.add(allProducts.get(i).getText().toLowerCase().trim());
                expectedData.add(allProducts.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expectedData);
            System.out.println(actualData);
            System.out.println(expectedData);
            Assert.assertEquals(actualData, expectedData);

        }


        @Test
        public void validateDescendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.opencart.com/admin/");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("demo");
            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();
            Thread.sleep(2000);
            WebElement submit = driver.findElement(By.cssSelector(".btn-close"));
            submit.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(3000);
            WebElement product = driver.findElement(By.linkText("Products"));
            product.click();
            WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
            productName.click();
            Thread.sleep(3000);
            List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
            ArrayList<String> actualData = new ArrayList<>();
            ArrayList<String> expectedData = new ArrayList<>();

            for (int i = 1; i < allProducts.size(); i++) {
                actualData.add(allProducts.get(i).getText().toLowerCase().trim());
                expectedData.add(allProducts.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expectedData);
            Collections.reverse(expectedData);
            System.out.println(actualData);
            System.out.println(expectedData);
            Assert.assertEquals(actualData, expectedData);


            List<WebElement> allPrices1 = driver.findElements(By.cssSelector(".primary-price"));
            List<Integer> actualPrices = new ArrayList<>();
            List<Integer> expectedPrices = new ArrayList<>();
            for (int i = 0; i < allPrices1.size(); i++) {
                actualPrices.add(Integer.parseInt (BrowserUtils.getText(allPrices1.get(i)).replace("$","").replace("","")));
                expectedPrices.add(Integer.parseInt (BrowserUtils.getText(allPrices1.get(i)).replace("$","").replace("","")));

            }
            Collections.sort(expectedPrices);
            Assert.assertEquals(actualPrices, expectedPrices);
            System.out.println(actualPrices);
            System.out.println(expectedPrices);

        }
    }
}