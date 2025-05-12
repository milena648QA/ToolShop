package tests;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import pages.PaymentAPIPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PaymentAPITest {


    @SneakyThrows
    @Test
    public void checkPayment() {
        String bodyText = Files.readString(Paths.get("src/test/resources/checkPayment.json"));

        PaymentAPIPage paymentAPIPage = new PaymentAPIPage();
        Response response = paymentAPIPage.checkPayment(bodyText);

        System.out.println(response.getBody().asString());
        Assert.assertEquals(200,response.getStatusCode());

    }
}
