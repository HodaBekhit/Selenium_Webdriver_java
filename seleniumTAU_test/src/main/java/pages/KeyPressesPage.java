package pages; // Declares the package where the class resides.

import org.openqa.selenium.By; // Import Selenium's By class to locate elements on the webpage.
import org.openqa.selenium.Keys; // Import Selenium's Keys class to simulate keyboard key presses.
import org.openqa.selenium.WebDriver; // Import Selenium's WebDriver interface for interacting with the browser.

public class KeyPressesPage {

    private WebDriver driver; // WebDriver instance for controlling the browser.

    // Locators for the input field and the result text element on the page.
    private By inputField = By.id("target"); // Locator for the input field where keys are entered (ID: "target").
    private By resultText = By.id("result"); // Locator for the result text area (ID: "result").

    /**
     * Constructor for initializing the KeyPressesPage class.
     * @param driver WebDriver instance to interact with the browser.
     */
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Method to enter text into the input field.
     * @param text The string to be entered into the input field.
     */
    public void enterText(String text){
        // Find the input field using its locator and enter the specified text.
        driver.findElement(inputField).sendKeys(text);
    }

    /**
     * Method to enter the mathematical constant Pi (π) into the input field.
     * This simulates pressing ALT + P followed by "=3.14".
     */
    public void enterPi(){
        // Use the chord method to simulate pressing multiple keys at the same time (ALT + P),
        // and then add the string "=3.14" to the input.
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    /**
     * Method to retrieve the result text that appears after key presses.
     * @return The result text as a string.
     */
    public String getResult(){
        // Find the result text element using its locator and return its text content.
        return driver.findElement(resultText).getText();
    }
}
