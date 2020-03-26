package ahs.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    static WebDriver driver;

    // returns the browser name, type and version, and sets body classes
    // detects major browsers: IE, Edge, Firefox, Chrome, Safari, Opera, Android
    public static WebDriver getBrowser(){

        if(driver == null){
            driver = invokeBrowser();
            return  driver;
        }
        else {
            return driver;
        }
    }

    private static WebDriver invokeBrowser() {//launch browser
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
//    private static WebDriver invokeBrowser() {//
//        DesiredCapabilities caps = null;
//        if (TestRunner.SauceLabs) {
//            if (TestRunner.BrowserName.equals("IE")) {
//                caps = DesiredCapabilities.internetExplorer();
//                caps.setCapability("platform", "Windows 7");
//                caps.setCapability("version", "9.0");
//
//            } else if (TestRunner.BrowserName.equals("FF")) {
//                caps = DesiredCapabilities.firefox();
//                caps.setCapability("platform", "Windows 10");
//                caps.setCapability("version", "57.0");
//            }
//            else if (TestRunner.BrowserName.equals("Chrome")) {
//                caps = DesiredCapabilities.chrome();
//                caps.setCapability("platform", "Windows 10");
//                caps.setCapability("version", "57.0");
//            }
//            try {
//                driver = new RemoteWebDriver(new URL("https://suresh_123:31001790-457a-4ff6-a0da-aaba290c2ba4@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        return driver;
//    }
//}
