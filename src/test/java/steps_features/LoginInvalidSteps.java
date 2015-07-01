package steps_features;
import cucumber.api.PendingException;
import page_objects.*;
import cucumber.api.java.en.*;

public class LoginInvalidSteps {

        private SharedDriver driver;

    public LoginInvalidSteps(SharedDriver driver){
        this.driver = driver;
    }
        @Given("^I am about to login$")
        public void I_am_about_to_login() throws Throwable {
            LoginPage page = new LoginPage(driver);
            if (!page.pageLoginExist(driver)) {
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
    }

