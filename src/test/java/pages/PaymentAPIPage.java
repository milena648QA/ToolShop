package pages;

import io.restassured.response.Response;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PaymentAPIPage extends BasePage {
    public Response checkPayment(String bodyText) {

        String url = "https://api.practicesoftwaretesting.com/";
        String path = "payment/check";

        Response response = postAPIResult(url,path,bodyText,"");
        return response;
    }

}
