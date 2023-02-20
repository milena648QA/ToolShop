package api.coinMarket;

import configuration.Configuration;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class ApiBase
{
    private final Configuration configuration = new Configuration();
    private final String keyName = "X-CMC_PRO_API_KEY";
    protected RequestSpecification requestSpecification = requestSpecificationSetup(keyName);


    private RequestSpecification requestSpecificationSetup(String key)
    {
        RequestSpecification httpRequest = given();
        httpRequest.contentType("application/json");
        httpRequest.header(key, configuration.getCoinMarketApiKey());
        httpRequest.baseUri(configuration.getCoinMarketBaseURI());

        return httpRequest;
    }
}