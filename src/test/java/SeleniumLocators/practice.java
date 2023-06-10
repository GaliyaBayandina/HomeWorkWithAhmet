package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class practice {
    public static void main(String[] args) throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

      WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
      firstName.sendKeys("Yuliia");
      WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
      lastName.sendKeys("Dutka");
      WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
      email.sendKeys("yus.dutkaa@gmail.com");
      WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
      telephone.sendKeys("1123323434");
      WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
      password.sendKeys("12344567");
      WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
      passwordConfirm.sendKeys("12344567");
      WebElement newsletter = driver.findElement(By.xpath("//input[@name='newsletter']"));
      newsletter.click();
      WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
      privacyPolicy.click();
      WebElement confirm = driver.findElement(By.xpath("//input[@value='Continue']"));
      confirm.click();
      WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));

      String actualHeader = header.getText();
      String expectedHeader = "Your Account Has Been Created!";
      System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Not Passed");

      WebElement cont = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
      cont.click();
      String actualURL = driver.getCurrentUrl();
      String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
      System.out.println(actualURL.equals(expectedURL) ? "Passed" : "Not passed");
      Thread.sleep(3000);

      driver.quit();
    }
}
