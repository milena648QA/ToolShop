package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.BrandsAPIPage;
import pages.UserAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BrandsAPITest {
    @Test
    public void retrieveAllBrands() {
        BrandsAPIPage brandsAPIPage = new BrandsAPIPage();
        Response response = brandsAPIPage.retrieveAllBrands();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.getStatusCode());

}

    @SneakyThrows
    @Test
    public void storeNewBrand() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));
        String bodyTextBrand = Files.readString(Paths.get("src/test/resources/storeNewBrand.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.loginCustomer(bodyText);

        BrandsAPIPage brandsAPIPage = new BrandsAPIPage();
        Response response = brandsAPIPage.storeNewBrand(UserAPIPage.token, bodyTextBrand);

        int statusCode = response.getStatusCode();
        System.out.println("status code:" + statusCode);
        System.out.println(response.getBody().asString());
        Assert.assertEquals(201,response.getStatusCode());


    }


    @Test
    public void retrieveSpecificBrand() {

        BrandsAPIPage brandsAPIPage = new BrandsAPIPage();
        Response response = brandsAPIPage.retrieveSpecificBrand();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }


     @Test
    public void retrieveSpecificBrandsMatchingTheSearchQuery() {

        BrandsAPIPage brandsAPIPage = new BrandsAPIPage();
        Response response = brandsAPIPage.retrieveSpecificBrandsMatchingTheSearchQuery();

         System.out.println(response.getBody().asString());
         Assert.assertEquals(200,response.getStatusCode());
     }
}
