package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pages.FavoritesAPIPage;

public class FavoritesAPITest {

    @Test
    public void retrieveAllFavorites() {
        FavoritesAPIPage favoritesAPIPage = new FavoritesAPIPage();
        Response response = favoritesAPIPage.retrieveAllFavorites();

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(200,statusCode);
    }
}
