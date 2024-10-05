package pages; // This line declares the package where the class resides.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Represents a page where hovering over figures shows captions.
 */
public class HoversPage {
    private WebDriver driver; // WebDriver instance used to interact with the browser.

    // Locators for the figure elements and their captions.
    private By figureBox = By.className("figure"); // Locator for figure elements (divs with class "figure").
    private By boxCaption = By.className("figcaption"); // Locator for caption elements (divs with class "figcaption").

    /**
     * Constructor for initializing the HoversPage class with a WebDriver.
     * @param driver WebDriver instance used to control the browser.
     */
    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method performs a hover action over a figure element.
     * @param index The figure index to hover over (starts at 1, so 1 corresponds to the first figure).
     * @return A FigureCaption object that provides access to the caption details.
     */
    public FigureCaption hoverOverFigure(int index){
        // Find the figure element by its index (index - 1 to adjust for 0-based indexing).
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        // Create an Actions object to perform complex user interactions like hovering.
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform(); // Perform the hover action.

        // Return a new FigureCaption object for the caption element related to the hovered figure.
        return new FigureCaption(figure.findElement(boxCaption));
    }

    /**
     * Nested class that represents the caption of a figure.
     * Provides methods to interact with the caption, like checking if it's displayed,
     * getting the title, or getting the link associated with the caption.
     */
    public class FigureCaption{

        private WebElement caption; // The WebElement representing the figure's caption.
        private By header = By.tagName("h5"); // Locator for the caption header (assumed to be inside an <h5> tag).
        private By link = By.tagName("a"); // Locator for the caption link (assumed to be inside an <a> tag).

        /**
         * Constructor for initializing the FigureCaption class.
         * @param caption The WebElement that represents the caption of a figure.
         */
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        /**
         * Checks if the caption is currently displayed on the page.
         * @return true if the caption is visible, false otherwise.
         */
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        /**
         * Retrieves the title (text inside the <h5> element) of the caption.
         * @return The caption title as a String.
         */
        public String getTitle(){
            return caption.findElement(header).getText();
        }

        /**
         * Retrieves the URL (href attribute) of the link inside the caption.
         * @return The URL as a String.
         */
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        /**
         * Retrieves the link text inside the caption.
         * @return The link text as a String.
         */
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}