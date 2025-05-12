package pages;

import io.restassured.response.Response;

public class ProductsAPIPage extends BasePage {
    public Response retrieveAllProducts() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products";

        Response response = getAPIResult(url, path, "", "");
        return response;
    }

    public Response storeNewProduct(String bodyText) {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products";

        Response response = postAPIResult(url, path,bodyText, "");
        return response;

    }

    public Response retrieveSpecificProduct() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products/";

        Response response = getAPIResult(url,path,"", "");
        return response;

    }

    public Response updateSpecificProduct(String bodyText) {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products/01JQMH3YSB7VQ7W3VDSSNT03CJ";

        Response response = putAPIResult(url,path,bodyText,"");
        return response;
    }

    public Response retrieveSpecificProductMatchingTheSearchQuery() {
        String url = "https://api.practicesoftwaretesting.com/";
        String path = "products/search?q=combinationpliers";

        Response response = getAPIResult(url,path,"","");
        return response;

    }

}
