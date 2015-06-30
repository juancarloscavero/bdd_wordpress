package page_objects;
import appium.AppiumMethods;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends AppiumMethods {
    By usernameValid = By.id("org.wordpress.android:id/nux_username");
    By passwordValid = By.id("org.wordpress.android:id/nux_password");
    By loginButton = By.id("org.wordpress.android:id/nux_sign_in_button");
    By addHost = By.id("org.wordpress.android:id/nux_add_selfhosted_button");
    By url = By.id("org.wordpress.android:id/nux_url");
    By next= By.id("org.wordpress.android:id/nux_dialog_footer_1_button");
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean pageLoginExist(AppiumDriver driver) {
        return pageExist(usernameValid);
    }

    public boolean pageMenuExist(AppiumDriver driver) {
        By menu = By.id("org.wordpress.android:id/menu_new_post");
        return pageExist(menu);
    }

    public void enterCredentials(String user, String pass) {
        fill(usernameValid, user);
        fill(passwordValid, pass);
        press(addHost);
        fill(url, "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press( loginButton);

    }
}