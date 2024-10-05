package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverListener {



    @Override
    public void beforeGetText(WebElement element) {
        System.out.println("Getting text from element: " + element.getTagName());
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on " + element.getText());
    }


}
