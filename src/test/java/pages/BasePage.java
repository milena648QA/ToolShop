package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Objects;

public class BasePage
{

    public Response getAPIResult(String url, String path, String bodyText, String token)
    {
        RestAssured.baseURI = url;

        RequestSpecification request = RestAssured.given();

        request.contentType("application/json");
        request.header("Connection","keep-alive");
        if(!Objects.equals(bodyText, ""))
        {
            request.body(bodyText);
        }
        if(!Objects.equals(token, ""))
        {
            request.header("Authorization", "Bearer " + token);
        }
        request.redirects();
        Response response = null;
        try
        {
            response = request.get(path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
    public Response postAPIResult(String url, String path, String bodyText, String token)
    {
        RestAssured.baseURI = url;

        RequestSpecification request = RestAssured.given();

        request.contentType("application/json");
        request.header("Connection","keep-alive");
        if(!Objects.equals(bodyText, ""))
        {
            request.body(bodyText);
        }
        if(!Objects.equals(token, ""))
        {
            request.header("Authorization", "Bearer " + token);
        }
        request.redirects();
        Response response = null;
        try
        {
            response = request.post(path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public Response putAPIResult(String url, String path, String bodyText, String token)
    {
        RestAssured.baseURI = url;

        RequestSpecification request = RestAssured.given();

        request.contentType("application/json");
        request.header("Connection","keep-alive");
        if(!Objects.equals(bodyText, ""))
        {
            request.body(bodyText);
        }
        if(!Objects.equals(token, ""))
        {
            request.header("Authorization", "Bearer " + token);
        }
        request.redirects();
        Response response = null;
        try
        {
            response = request.put(path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

}
