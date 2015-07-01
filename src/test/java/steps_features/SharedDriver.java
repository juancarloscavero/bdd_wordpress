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

    public SharedDriver()  {
        super(InitializeCapabilities.CreateURL(), InitializeCapabilities.CreateCapabilities());

    }
    @After
     public void tearDown() throws Exception {
        quit();
    }
}

