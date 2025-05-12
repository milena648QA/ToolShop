package pages;

import io.restassured.response.Response;
import org.json.JSONObject;

public class CartAPIPage extends BasePage
{

    public Response createNewCart(String token)
    {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "carts";


        Response response = postAPIResult(url,path,"",token);
        JSONObject responseObject = new JSONObject(response.getBody().asString());

        return  response;
    }

    public Response addItemToCart() {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "carts/01HHJC7RERZ0M3VDGS6X9HM33A";

        Response response = postAPIResult(url, path, "","");
        return response;

    }

    public Response retrieveSpecificCart() {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "carts/1";

        Response response = getAPIResult(url,path,"","");
        return response;
    }


}
