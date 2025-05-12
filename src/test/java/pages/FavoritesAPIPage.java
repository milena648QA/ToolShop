package pages;

import io.restassured.response.Response;

import static pages.UserAPIPage.token;

public class FavoritesAPIPage extends BasePage {

    public Response retrieveAllFavorites()
    {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "favorites";

        Response response = getAPIResult(url,path,"", token);
        return response;
    }

    public Response storeNewFavorite(String bodyText)
    {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "favorites";

        Response response = postAPIResult(url,path,bodyText,token);
        System.out.println(response.getBody().asString());
        return response;

    }
}
