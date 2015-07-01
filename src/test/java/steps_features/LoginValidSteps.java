package steps_features;
import cucumber.api.PendingException;
import page_objects.*;
import cucumber.api.java.en.*;

public  class LoginValidSteps {
    private SharedDriver driver;

        public LoginValidSteps(SharedDriver driver){
            this.driver = driver;
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
}
