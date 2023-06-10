package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathrealHealthProject {
     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
     public static void main(String[] args) throws InterruptedException {
         WebDriverManager.chromedriver().setup();

         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         ChromeDriver driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeApoitment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
         makeApoitment.click();
         WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
         userName.sendKeys("John Doe");
         WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
         WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
      login.click();
      WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
      facility.sendKeys("Hongkong CURA Healthcare Center");
         WebElement checkbox= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
         if (checkbox.isDisplayed()&&!checkbox.isSelected()){
             checkbox.click();}
         WebElement healthCareProgram = driver.findElement(By.xpath("//input[@value='Medicaid']"));
         healthCareProgram.click();
         WebElement data = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
         data.sendKeys("06/02/2023");
         Thread.sleep(3000);
         WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
         comment.sendKeys("Want make check up");
         WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
         bookAppointment.click();
         Thread.sleep(3000);
         WebElement appointmentConfirmation = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
         String actualHeader = appointmentConfirmation.getText().trim();
         String expectedHeader ="Appointment Confirmation";
         System.out.println(actualHeader.equals(expectedHeader)? "PASSED" : "FAILED");

         WebElement commentValidation = driver.findElement (By.xpath (  " / /p[contains(text (), 'Want')]"));
         System.out.println(commentValidation.getText().trim());
         Thread. sleep (  5000);
         driver .quit ();
/*
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
 */














     }
}
