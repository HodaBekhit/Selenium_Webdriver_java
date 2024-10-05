package base;
import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter; // Import your EventReporter
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    private EventReporter eventReporter;

    @BeforeClass
    // Set up the WebDriver with ChromeOptions and EventFiringDecorator
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        // Create a ChromeDriver instance with ChromeOptions
        ChromeDriver chromeDriver = new ChromeDriver(getChromeOptions());

        // Create an EventReporter instance
        eventReporter = new EventReporter();

        // Wrap ChromeDriver with EventFiringDecorator and register the EventReporter
        WebDriverListener listener = eventReporter;
        driver = new EventFiringDecorator<>(listener).decorate(chromeDriver);

        // Navigate to the desired page and set cookies
        goHome();
        setCookie();
    }


    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
      //  driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        // Add argument to suppress the automation infobar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
