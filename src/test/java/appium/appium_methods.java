package appium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class appium_methods {

    public  void press(AppiumDriver driver, By by){
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public  void fill(AppiumDriver driver, By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public  boolean pageExist(AppiumDriver driver, By by) {

        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(by));
           // driver.findElement(by);
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }
}
