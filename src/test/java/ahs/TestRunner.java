package ahs;

import ahs.support.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty","html:target/cucumber-html-report","json:target/cucumber.json"}
        //tags = {"@master"}

        )
public class TestRunner {

    static WebDriver browser;
    public static boolean SauceLabs = true;
    public static String BrowserName = "Chrome";

    @BeforeClass
    public static void initBrowser(){
        //Initializes a browser view controller with the provided browser and session
        browser = BrowserFactory.getBrowser();
    }
    @AfterClass
    public static void close(){
        browser.quit();
        browser = null;
    }
}

//@appointment"@master1","@master2","@master3","@appointment",