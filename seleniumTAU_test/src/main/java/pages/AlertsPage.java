package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Locators for the buttons that trigger JavaScript alerts, confirms, and prompts
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

    // Locator for the result text on the page
    private By results = By.id("result");

    // Constructor to initialize the WebDriver instance
    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to trigger a JavaScript Alert by clicking the corresponding button
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    // Method to trigger a JavaScript Confirm by clicking the corresponding button
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    // Method to trigger a JavaScript Prompt by clicking the corresponding button
    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    // Method to accept the alert (click OK)
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    // Method to dismiss the alert (click Cancel)
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    // Method to get the text displayed in the alert
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    // Method to set input text in a JavaScript prompt (used for prompts that accept input)
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    // Method to get the result text displayed on the page after interacting with the alert
    public String getResult(){
        return driver.findElement(results).getText();
    }
}
