package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class UserAPIPage extends BasePage
{
    public static String token;

    public Response storeNewUser(String bodyText)
    {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "users/register";

        Response response = postAPIResult(url,path,bodyText,"");
        return  response;
    }

    public Response loginCustomer(String bodyText)
    {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "users/login";

        Response response = postAPIResult(url,path,bodyText,"");

        System.out.println("response:"+response.getBody().asString());
        JSONObject responseJSON = new JSONObject(response.getBody().asString());
        token = responseJSON.getString("access_token");
        return response;

    }

    public Response changePassword(String bodyText)
    {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "users/change-password";

        Response response = postAPIResult(url,path,bodyText,token);
        return response;
    }

    public Response retrieveAllUsers()
    {
        RestAssured.baseURI = "https://api.practicesoftwaretesting.com/";

        RequestSpecification request = RestAssured.given();

        request.contentType("application/json");
        request.header("Connection","keep-alive");

        request.header("Authorization","Bearer "+ token);
        request.redirects();
        Response response = null;
        try {
            response = request.get("users/me");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;

    }

    public Response retrieveCurrentCustomerInfo( String token, String loginBodyText) {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "users/me";

        Response response = getAPIResult(url,path,loginBodyText, token);

        JSONObject responseJSON = new JSONObject(response.getBody().asString());
        return response;
    }


}