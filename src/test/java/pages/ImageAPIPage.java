package pages;

import io.restassured.response.Response;

public class ImageAPIPage extends BasePage {

    public Response retrieveAllImages() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "images";

        Response response = getAPIResult(url, path,"","");
        return response;
    }
}
