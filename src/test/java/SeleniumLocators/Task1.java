package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
    /*
     Navigate to "https://demoqa.com/text-box"
    Enter your full name, email, current and permanent address
    Click submit button.
 Validate that all of your information is displayed and matching correctly.
TIPS:Think about if conditions.
Example:
Name:John
Email: john@gmail.com
Current Address :Random Address
Permanent  Address : different address
Steps
     */
    public static void main(String[] args) throws InterruptedException {
                /*
        Test Case 1 Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address
Click submit button.
Validate that all of your information is displayed and
matching correctly.
TIPS:Think about if conditions.
Example:
Name:John
Email:
Current Address :Random Address
Permanent  Address : different address
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        String actualUrl=driver.getCurrentUrl();
        String expectedurl="https://demoqa.com/text-box";
        System.out.println(actualUrl.equals(expectedurl) ? "Passed Url" : "Failed Url");

        WebElement fullName=driver.findElement(By.id("userName"));
        fullName.sendKeys("John");

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys(" john@gmail.com");

        WebElement currectAddress=driver.findElement(By.id("currentAddress"));
        currectAddress.sendKeys("1770 13th street, apt 2D,Brooklyn NY 11229");

        WebElement pemanetAddress=driver.findElement(By.id("permanentAddress"));
        pemanetAddress.sendKeys("2200 DEVON AVE 60656");

        WebElement botton=driver.findElement(By.id("submit"));
        botton.click();



        WebElement nameValidate=driver.findElement(By.xpath("//p[@id='name']"));
        if(nameValidate.isDisplayed()){
            System.out.println(nameValidate.getText());
        }
        WebElement emailValidate=driver.findElement(By.xpath("//p[@id='email']"));
        if(emailValidate.isDisplayed()){
            System.out.println(emailValidate.getText());
        }
        WebElement currectValidate=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if(currectValidate.isDisplayed()){
            System.out.println(currectValidate.getText());
        }
        WebElement permanentValidate=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if(permanentValidate.isDisplayed()){
            System.out.println(permanentValidate.getText());
        }
    }
}