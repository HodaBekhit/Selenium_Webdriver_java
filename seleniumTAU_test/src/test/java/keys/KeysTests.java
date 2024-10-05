package keys; // Declares the package where the class resides.

import base.BaseTests; // Importing the BaseTests class to inherit common setup/teardown functionalities.
import org.openqa.selenium.Keys; // Importing Selenium's Keys class to simulate keyboard key presses.
import org.testng.annotations.Test; // Importing TestNG's @Test annotation for defining test methods.

import static org.testng.Assert.assertEquals; // Importing the static assertEquals method for assertions in the tests.

public class KeysTests extends BaseTests {

    /**
     * Test case to simulate entering the letter "A" followed by a backspace,
     * and verify that the expected result is returned.
     */
    @Test
    public void testBackspace(){
        // Navigate to the KeyPresses page.
        var keyPage = homePage.clickKeyPresses();

        // Enter the letter "A" followed by a backspace key press.
        keyPage.enterText("A" + Keys.BACK_SPACE);

        // Verify that the result message indicates the BACK_SPACE key was pressed.
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }

    /**
     * Test case to simulate entering the Pi symbol (π).
     * This test currently stops short of full validation, as noted in the comments.
     */
    @Test
    public void testPi(){
        // Navigate to the KeyPresses page.
        var keyPage = homePage.clickKeyPresses();

        // Simulate entering the Pi symbol.
        keyPage.enterPi();

        /*
            NOTE: we didn't finish this test in the video.
            We debugged to watch it enter the Pi key.
            (No assertion is present since this test is unfinished)
         */
    }
}
