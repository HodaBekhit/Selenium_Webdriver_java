package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Updated to use Duration
        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(loadingIndicator)));*/

        /* FLUENT WAIT */
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))                 // Total wait time (5 seconds)
                .pollingEvery(Duration.ofSeconds(1))                // Polling interval (1 second)
                .ignoring(NoSuchElementException.class);            // Ignore specific exceptions (NoSuchElementException)
        fluentWait.until(ExpectedConditions.invisibilityOf(
               driver.findElement(loadingIndicator)));

    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
