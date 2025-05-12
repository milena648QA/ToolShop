package pages;

import io.restassured.response.Response;
import org.json.JSONObject;

import static pages.UserAPIPage.token;

public class BrandsAPIPage extends BasePage {

    public Response retrieveAllBrands() {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "brands";

        Response response = getAPIResult(url, path, "", "");
        return response;
    }

    public Response storeNewBrand(String token, String bodyTextBrand) {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "brands";

        Response response = postAPIResult(url,path,bodyTextBrand,token);

        JSONObject responseJSON = new JSONObject(response.getBody().asString());
        return response;


    }

    public Response retrieveSpecificBrand() {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "brands/01JRTTRWVV3DG9DYXXAMZXSPEB";

        Response response = getAPIResult(url,path,"","");
        return response;

    }

    public Response retrieveSpecificBrandsMatchingTheSearchQuery() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products/search?q=pliers";

        Response response = getAPIResult(url, path, "","");
        return response;

    }

}
