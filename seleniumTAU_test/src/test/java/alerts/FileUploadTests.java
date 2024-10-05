package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Dell\\Desktop\\ischool\\Hoda-Ahmed-Bekhit.pdf");
        assertEquals(uploadPage.getUploadedFiles(), "Hoda-Ahmed-Bekhit.pdf", "Uploaded files incorrect");
    }
}
