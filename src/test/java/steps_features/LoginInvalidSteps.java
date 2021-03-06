package steps_features;
import cucumber.api.PendingException;
import page_objects.*;
import java.io.File;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class LoginInvalidSteps {

        private SharedDriver driver;

    public LoginInvalidSteps(SharedDriver driver){
        this.driver = driver;
    }

        @Given("^I am about to login$")
        public void I_am_about_to_login() throws Throwable {
            LoginPage page = new LoginPage(driver);
            if (!page.pageLoginExist()) {
                throw new PendingException("Error, I am not on login page");
            }
        }

        @When("^I enter invalid credentials$")
        public void I_enter_invalid_credentials(){
            LoginPage page = new LoginPage(driver);
            page.enterCredentials("wrong", "1234");
        }

        @Then("^I am on login page$")
        public void I_am_in_login_page() throws Throwable{
            LoginPage page = new LoginPage(driver);
            if (!page.pageLoginExist()) {
                throw new PendingException("Error, I am not on Main menu");
            }
        }
    }

