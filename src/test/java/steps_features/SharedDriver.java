package steps_features;

import cucumber.api.java.After;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SharedDriver extends AndroidDriver {
   private static URL url;
   private static DesiredCapabilities capabilities;
  static {
      File classpathRoot = new File(System.getProperty("user.dir"));
      File appDir = new File(classpathRoot, "apps");
      File app = new File(appDir, "Workshop.apk");
      capabilities = new DesiredCapabilities();
      capabilities.setCapability("deviceName", "emulator-5554");
      capabilities.setCapability("platformVersion", "5.0");
      capabilities.setCapability("app", app.getAbsolutePath());

      try {
          url = new URL ("http://127.0.0.1:4723/wd/hub");
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
  }
    public SharedDriver()  {
        super(url, capabilities);
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "Workshop.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("platformVersion", "5.0");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
     public void tearDown() throws Exception {
        quit();
    }
}

