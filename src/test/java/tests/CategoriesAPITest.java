package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.CategoriesAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CategoriesAPITest {
    @Test
    public void retrieveAllCategoriesWithSubcategories()
    {
        CategoriesAPIPage categoriesAPIPage = new CategoriesAPIPage();
        Response response = categoriesAPIPage.retrieveAllCategoriesWithSubcategories();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());

    }

    @Test
    public void retrieveAllCategories()
    {
        CategoriesAPIPage categoriesAPIPage = new CategoriesAPIPage();
        Response response = categoriesAPIPage.retrieveAllCategories();

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());
    }

    @SneakyThrows
    @Test
    public void storeNewCategories()
    {
        String bodyText = Files.readString(Paths.get("src/test/resources/storeNewCategory.json"));

        CategoriesAPIPage categoriesAPIPage = new CategoriesAPIPage();
        Response response = categoriesAPIPage.storeNewCategories(bodyText);

        System.out.println(response.getBody().asString());
        Assert.assertEquals(201,response.getStatusCode());

    }

    @SneakyThrows
    @Test
    public void updateSpecificCategory()
    {
        String bodyText = Files.readString(Paths.get("src/test/resources/updateSpecificCategory.json"));

        CategoriesAPIPage categoriesAPIPage = new CategoriesAPIPage();
        Response response = categoriesAPIPage.updateSpecificCategory(bodyText);

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());

    }

}
