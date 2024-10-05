package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";  // The iframe ID for the editor
    private By textArea = By.id("tinymce");       // Locator for the text area within the iframe
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button"); // Locator for the Decrease Indent button

    // Constructor to initialize the driver
    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to clear the text in the text area
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    // Method to set text in the text area
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    // Method to retrieve the current text from the editor
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    // Method to decrease indentation
    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }

    // Switch to the iframe containing the editor
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    // Switch back to the main content from the iframe
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
