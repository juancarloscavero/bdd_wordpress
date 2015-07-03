package steps_features;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.LoginPage;
import page_objects.MainMenu;
import sun.security.util.PendingException;

public class PostSteps {
    private SharedDriver driver;

    public PostSteps(SharedDriver driver){
        this.driver = driver;
    }

    @Given("^I am logged$")
    public void I_am_logged() throws Throwable{
        LoginValidSteps login = new LoginValidSteps(driver);
        login.I_enter_valid_credentials();
        MainMenu page = new MainMenu(driver);
        if (!page.pageMenuExist()){
            throw new PendingException("Error, I am not on Main menu");
        }
    }

    @When("^I press in add button$")
    public void I_press_in_add_button(){
        MainMenu page = new MainMenu(driver);
        page.addPost();
    }

    @And("^I fill the fields$")
    public void I_fill_the_fields(){
        MainMenu page = new MainMenu(driver);
        page.fillPost("Hola", "Caracola");
        page.testPost("Hola", "Caracola");
    }

    @And("^I fill fields with special characters$")
    public void I_fill_fields_with_words_reservates(){
        MainMenu page = new MainMenu(driver);
        page.fillPost("Hola","<Caracola>");
        page.testPost("Hola","<Caracola>");
    }
    @Then("^I see my post$")
    public void I_see_my_post(){
    }

    @Given("^I am in post page$")
    public void I_am_in_post_page(){
        LoginValidSteps login = new LoginValidSteps(driver);
        login.I_enter_valid_credentials();
        MainMenu page = new MainMenu(driver);
    }
    @When("^I press button delete$")
    public void I_press_button_delete(){
        MainMenu page = new MainMenu(driver);
        page.deletePost();
    }

    @Then("^Post deleted$")
    public void Post_deleted(){

    }

}
