package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.UserAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class UserAPITest {


    @Test
    public void storeNewUserJSONTest() {
        try {
            String bodyText = Files.readString(Paths.get("src/test/resources/user.json"));

            UserAPIPage userAPIPage = new UserAPIPage();
            Response response = userAPIPage.storeNewUser(bodyText);

            int statusCode = response.getStatusCode();
            System.out.println("status code:" + statusCode);
            Assert.assertEquals(201,statusCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @SneakyThrows
    @Test
    public void loginCustomerTest() {
        String bodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        Response response = userAPIPage.loginCustomer(bodyText);

        int statusCode = response.getStatusCode();
        System.out.println("status code:" + statusCode);
        Assert.assertEquals(200, statusCode);
    }


    @Test
    public void changePasswordTest() {
        try {
            String bodyText = Files.readString(Paths.get("src/test/resources/changePassword.json"));
            String loginBodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));

            UserAPIPage userAPIPage = new UserAPIPage();
            userAPIPage.loginCustomer(loginBodyText);
            Response response = userAPIPage.changePassword(bodyText);

            int statusCode = response.getStatusCode();
            System.out.println("status code:" + statusCode);
            Assert.assertEquals(200, statusCode);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SneakyThrows
    @Test
    public void retrieveAllUsersTest() {
        try {
            String loginBodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));

            UserAPIPage userAPIPage = new UserAPIPage();
            userAPIPage.loginCustomer(loginBodyText);
            Response response = userAPIPage.retrieveAllUsers();
            System.out.println(response.getBody().asString());

            int statusCode = response.getStatusCode();
            System.out.println("status code:" + statusCode);
            Assert.assertEquals(200, statusCode);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SneakyThrows
    @Test
    public void retrieveCurrentCustomerInfo() {

        String loginBodyText = Files.readString(Paths.get("src/test/resources/loginCustomer.json"));

        UserAPIPage userAPIPage = new UserAPIPage();
        userAPIPage.loginCustomer(loginBodyText);

        Response response = userAPIPage.retrieveCurrentCustomerInfo(UserAPIPage.token, loginBodyText);


        int statusCode = response.getStatusCode();
        System.out.println("status code:" + statusCode);
        Assert.assertEquals(200,response.getStatusCode());
    }
}