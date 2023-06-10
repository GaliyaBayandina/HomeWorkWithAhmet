package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1Nazik {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //XPATH
        //WebElement makeappoitment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //CSS

        WebElement makeappoitment= driver.findElement(By.cssSelector("#bn-make-appointment"));
        makeappoitment.click();





        WebElement username=driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement applyButton=driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        applyButton.click();
        WebElement medicaid=driver.findElement(By.xpath("//input[@name='programs']"));
        medicaid.click();
        WebElement data=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        data.sendKeys("05/04/23");
        WebElement comment=driver.findElement(By.xpath("//textArea[@name='comment']"));
        comment.sendKeys("I would like to make in Appoitment");


        //WebElement bookappoitment=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        //CSS WITH ID
        WebElement bookappoitment=driver.findElement(By.cssSelector(".btn-default"));
        bookappoitment.click();



        WebElement header=driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String  actualAppoitment =header.getText().trim();
        String expectedAppoitment="Appointment Confirmation";
        System.out.println(actualAppoitment.equals(expectedAppoitment) ? "Passed actual" : "Failed actual");
        String headerAppoitmentUrl=driver.getCurrentUrl();
        String expectedUrl="https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        System.out.println(headerAppoitmentUrl.equals(expectedUrl) ? "Passed Url" : "Failed Url");
        WebElement goback=driver.findElement(By.linkText("Go to Homepage"));
        goback.click();
        driver.close();









    }
}
