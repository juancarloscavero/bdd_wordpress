package page_objects;
import appium.AppiumMethods;
import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import sun.security.util.PendingException;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class MainMenu extends AppiumMethods{
    By addButton = By.id("org.wordpress.android:id/menu_new_post");
    By titleField = By.id("org.wordpress.android:id/post_title");
    By textField = By.id("org.wordpress.android:id/post_content");
    By publish = By.id("org.wordpress.android:id/menu_save_post");
    By editPost = By.id("org.wordpress.android:id/editPost");
    By seePost = By.id("org.wordpress.android:id/menu_posts_btn");
    By postPrincipal = By.id("org.wordpress.android:id/row_post_root");
    By deletePost = By.id("org.wordpress.android:id/deletePost");
    By yesButton = By.id("android:id/button1");
    public MainMenu(AppiumDriver driver) {
        super(driver);
    }

    public void addPost(){
        press(addButton);
    }
    public void fillPost(String title, String text){
        fill(titleField, title);
        fill(textField, text);
        driver.navigate().back();
        press(publish);
    }

    public void testPost(String expectedTitle, String expectedText){
        press(seePost);
        press(editPost);
        String title = driver.findElement(titleField).getText();
        String text = driver.findElement(textField).getText();
        try{
            assertEquals(title, expectedTitle);
            assertEquals(text, expectedText);
        }catch (AssertionError error){
            throw new PendingException("Error, don't match the words");

        }
    }

    public void deletePost(){
        press(postPrincipal);
        press(deletePost);
        press(yesButton);
    }

    public void postDeleted(String expectedTitle){
        press(seePost);
        press(editPost);
        String title =driver.findElement(titleField).getText();
//        try{
//            assertEquals(title, expectedTitle);
//
//        }catch (AssertionError error){
//            throw new PendingException("Error, don't match the words");
//
//        }
    }
    public boolean pageMenuExist() {
        By menu = By.id("org.wordpress.android:id/menu_new_post");
        return pageExist(menu);
    }
}
