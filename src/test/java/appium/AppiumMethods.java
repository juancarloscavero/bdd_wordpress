package appium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumMethods {
    protected final AppiumDriver driver;
    protected final WebDriverWait wait;

    public AppiumMethods(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public  void press( By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public  void fill(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public  boolean pageExist(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }
}
