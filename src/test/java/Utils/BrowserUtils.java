package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static String getText (WebElement element ){
        return  element.getText().trim();
    }
    public static void selectBy(WebElement location, String value, String methodName){
        Select select = new Select(location);
        switch (methodName){
            case"text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case"index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your method name is not correct");
                Assert.assertTrue(false);
        }

    }
    public static String getTitleWithJs(WebDriver driver ){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }
    public static  void clickWithJs (WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);


    }
    public static  void scrollWithJs  (WebDriver driver ,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }
    public static void switchById (WebDriver driver){
        String mainPage = driver.getWindowHandle();//this is my current driver  page id
        Set<String> allPages = driver.getWindowHandles();//all pages id(include second page)
        for (String id:allPages){
            if(!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }

        }
    }

 public static void  switchByTitle (WebDriver driver,String title ){
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id: allPagesId){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;

            }
        }
 }
 public static void getScreenShot(WebDriver driver, String packageName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location= System.getProperty("st/test/java/" + packageName+"/");
     try {
         FileUtils.copyFile(file, new File(location + System.currentTimeMillis()));
     } catch (IOException e) {
         throw new RuntimeException(e);
     }

 }
}
