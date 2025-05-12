package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.CartAPIPage;
import pages.UserAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CartAPITest {

    @SneakyThrows
    @Test
    public void  createNewCart() {

        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));

        CartAPIPage cartAPIPage = new CartAPIPage();
        Response response = cartAPIPage.createNewCart(UserAPIPage.token);


        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(201,statusCode);

    }

    @Test
    public void addItemToCart() {

        CartAPIPage cartAPIPage = new CartAPIPage();
        Response response = cartAPIPage.createNewCart(UserAPIPage.token);
        cartAPIPage.addItemToCart();

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(201,statusCode);

    }


    @Test
    public void retrieveSpecificCart() {

        CartAPIPage cartAPIPage = new CartAPIPage();
        Response response = cartAPIPage.retrieveSpecificCart();

        int statusCode = response.getStatusCode();
        System.out.println("status code:"+statusCode);
        Assert.assertEquals(201,statusCode);
    }
}
