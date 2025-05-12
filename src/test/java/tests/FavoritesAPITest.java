package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.FavoritesAPIPage;
import pages.UserAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FavoritesAPITest {

    @SneakyThrows
    @Test
    public void retrieveAllFavorites() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));
        String bodyText2 = Files.readString(Paths.get("src/test/resources/user.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.storeNewUser(bodyText2);
        userAPIPage.loginCustomer(bodyText);

        FavoritesAPIPage favoritesAPIPage = new FavoritesAPIPage();
        Response response = favoritesAPIPage.retrieveAllFavorites();

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(200,statusCode);
    }
}
