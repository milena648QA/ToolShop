package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.ProductsAPIPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProductsAPITest {

    @Test
    public void retrieveAllProducts() {

        ProductsAPIPage productsAPIPage = new ProductsAPIPage();
        Response response = productsAPIPage.retrieveAllProducts();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());

    }

    @SneakyThrows
    @Test
    public void storeNewProduct() {
        String bodyText = Files.readString(Paths.get("src/test/resources/storeNewProduct.json"));

        ProductsAPIPage productsAPIPage = new ProductsAPIPage();
        Response response = productsAPIPage.storeNewProduct(bodyText);

        System.out.println(response.getBody().asString());
        Assert.assertEquals(201,response.getStatusCode());

    }

    @Test
    public void retrieveSpecificProduct() {

        ProductsAPIPage productsAPIPage = new ProductsAPIPage();
        Response response = productsAPIPage.retrieveSpecificProduct();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }

    @SneakyThrows
    @Test
    public void updateSpecificProduct()  {
        String bodyText = Files.readString(Paths.get("src/test/resources/updateSpecificProduct.json"));

        ProductsAPIPage productsAPIPage = new ProductsAPIPage();
        Response response = productsAPIPage.updateSpecificProduct(bodyText);

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test
    public void retrieveSpecificProductMatchingTheSearchQuery() {

        ProductsAPIPage productsAPIPage = new ProductsAPIPage();
        Response response = productsAPIPage.retrieveSpecificProductMatchingTheSearchQuery();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.getStatusCode());
    }
}
