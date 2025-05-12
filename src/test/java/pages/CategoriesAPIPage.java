package pages;

import io.restassured.response.Response;


public class CategoriesAPIPage extends BasePage {

    public Response retrieveAllCategoriesWithSubcategories() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "categories/tree";

        Response response = getAPIResult(url, path, "", "");
        return response;
    }

    public Response retrieveAllCategories() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "categories";

        Response response = getAPIResult(url, path, "", "");
        return response;
    }

    public Response storeNewCategories(String bodyText) {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "categories";

        Response response = postAPIResult(url,path,bodyText,"");
        return response;
    }

    public Response updateSpecificCategory(String bodytext) {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "categories/01JQ1VQKV0PYRS463AYZKDGWD6";

        Response response = putAPIResult(url,path,bodytext,"");
        return response;
    }
}


