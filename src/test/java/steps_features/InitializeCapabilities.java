package steps_features;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class InitializeCapabilities {
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
//        public InitializeCapabilities(){
//            File classpathRoot = new File(System.getProperty("user.dir"));
//            File appDir = new File(classpathRoot, "apps");
//            File app = new File(appDir, "Workshop.apk");
//            capabilities = new DesiredCapabilities();
//            capabilities.setCapability("deviceName", "emulator-5554");
//            capabilities.setCapability("platformVersion", "5.0");
//            capabilities.setCapability("app", app.getAbsolutePath());
//            try {
//                url = new URL("http://127.0.0.1:4723/wd/hub");
//            } catch (MalformedURLException f) {
//                f.printStackTrace();
//            }
//        }
       public  DesiredCapabilities CreateCapabilities() {

        return capabilities;
    }
        public  URL CreateURL(){

            return url;
        }
}
