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
    public void retrieveAllFavoritesTest() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));
        String bodyText2 = Files.readString(Paths.get("src/test/resources/user.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.storeNewUser(bodyText2);
        userAPIPage.loginCustomer(bodyText);

        FavoritesAPIPage favoritesAPIPage = new FavoritesAPIPage();
        Response response = favoritesAPIPage.retrieveAllFavorites();
        System.out.println(response.getBody().asString());

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(200,statusCode);
    }

    @SneakyThrows
    @Test
    public void storeNewFavoriteTest() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));
        String bodyText2 = Files.readString(Paths.get("src/test/resources/user.json"));
        String bodyText3 = Files.readString(Paths.get("src/test/resources/storeNewFavorite.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.storeNewUser(bodyText2);
        userAPIPage.loginCustomer(bodyText);

        FavoritesAPIPage favoritesAPIPage = new FavoritesAPIPage();
        Response response = favoritesAPIPage.storeNewFavorite(bodyText3);

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(201,statusCode);

    }

    @SneakyThrows
    @Test
    public void retrieveSpecificFavoriteTest() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));
        String bodyText2 = Files.readString(Paths.get("src/test/resources/user.json"));
        String bodyText3 = Files.readString(Paths.get("src/test/resources/storeNewFavorite.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.storeNewUser(bodyText2);
        userAPIPage.loginCustomer(bodyText);

        FavoritesAPIPage favoritesAPIPage = new FavoritesAPIPage();
        Response response = favoritesAPIPage.retrieveSpecificFavorite();

        int statusCode = response.getStatusCode();
        System.out.println("status code:" + statusCode);
        Assert.assertEquals(200, statusCode);
    }
}
