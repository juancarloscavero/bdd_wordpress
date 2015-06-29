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

public  class Stepdefs {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "Workshop.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Given("^I am about to login$")
    public void I_am_about_to_login() throws Throwable {
        LoginPage page = new LoginPage(driver);
        if (!page.pageLoginExist(driver)) {
            throw new PendingException("Error, no estoy en la pagina correcta");
        }
    }

    @When("^I enter valid credentials$")
    public void I_enter_valid_credentials(){
        LoginPage page = new LoginPage(driver);
        page.enterCredentials("calabash", "password");
    }

    @Then("^I am in main menu$")
    public void I_am_in_main_menu() throws Throwable{
        LoginPage page = new LoginPage(driver);
        if (!page.pageMenuExist(driver)) {
            throw new PendingException("Error, no estoy en la pagina correcta");
        }
    }

    @When("^I enter invalid credentials$")
    public void I_enter_invalid_credentials(){
        LoginPage page = new LoginPage(driver);
        page.enterCredentials("wrong", "1234");
    }

    @Then("^I am in login page$")
    public void I_am_in_login_page() throws Throwable{
        LoginPage page = new LoginPage(driver);
        if (!page.pageLoginExist(driver)) {
            throw new PendingException("Error, no estoy en la pagina correcta");
        }
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
