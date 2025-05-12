package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pages.ImageAPIPage;

public class ImageAPITest {

    @Test
    public void retrieveAllImages() {

        ImageAPIPage imageAPIPage = new ImageAPIPage();
        Response response = imageAPIPage.retrieveAllImages();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }
}
