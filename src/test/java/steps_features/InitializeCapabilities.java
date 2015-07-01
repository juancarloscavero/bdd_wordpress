package steps_features;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class InitializeCapabilities{
    public static URL url;
    public static DesiredCapabilities capabilities;

       public static DesiredCapabilities CreateCapabilities() {

            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "apps");
            File app = new File(appDir, "Workshop.apk");
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformVersion", "5.0");
            capabilities.setCapability("app", app.getAbsolutePath());
            return capabilities;
    }
        public static URL CreateURL(){
            try {
                url = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (MalformedURLException f) {
                f.printStackTrace();
            }
            return url;
        }
}
