package page_objects;
import appium.appium_methods;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends appium_methods {
    private final AppiumDriver driver;
    By usernameValid = By.id("org.wordpress.android:id/nux_username");
    By passwordValid = By.id("org.wordpress.android:id/nux_password");
    By loginButton = By.id("org.wordpress.android:id/nux_sign_in_button");
    By addHost = By.id("org.wordpress.android:id/nux_add_selfhosted_button");
    By url = By.id("org.wordpress.android:id/nux_url");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean pageLoginExist(AppiumDriver driver) {
        return pageExist(driver, usernameValid);
    }

    public boolean pageMenuExist(AppiumDriver driver) {
        By menu = By.id("org.wordpress.android:id/menu_new_post");
        return pageExist(driver, menu);
    }

    public LoginPage enterCredentials(String user, String pass) {
        fill(driver, usernameValid, user);
        fill(driver, passwordValid, pass);
        press(driver, addHost);
        fill(driver, url, "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press(driver, loginButton);
        return this;
    }


}